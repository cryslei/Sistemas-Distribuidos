/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import classes.MsgCli;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;


/**
 *
 * @author Madianita
 */
public class ThreadAtende extends Thread{
    private ObjectInputStream recebeObj;
    private PrintStream enviaStr;
    private MsgCli msgRecebida;
    private Socket cSocket; 
    private ArrayList contatos;
    private ArrayList nicks;
  
    //private File arquivo;
    
    public ThreadAtende(Socket cSocket,ArrayList contatos,ArrayList nicks) {//,File arquivo//
        this.cSocket = cSocket;
        this.contatos = contatos;
        this.nicks = nicks;

    }
 
    public void run(){              
            try 
            {

                recebeObj =  new ObjectInputStream(cSocket.getInputStream());
                enviaStr = new PrintStream(cSocket.getOutputStream(), true);
                
                while(true)
                {
                    msgRecebida = (MsgCli) recebeObj.readObject(); //Recebe um objeto de MsgCli
                    
                    
                    if (msgRecebida.getOpcao().equalsIgnoreCase("inserir")){
                        if (!nicks.contains(msgRecebida.getPessoa().getApelido())){
                            nicks.add(msgRecebida.getPessoa().getApelido());
                        }
                        
                        System.out.println("Opção recebida: " + msgRecebida.getOpcao() + 
                                                             "\t" + msgRecebida.getPessoa().toString());
                        
                        //adicionar no array contato
                        
                        contatos.add(msgRecebida.getPessoa().toString());
                        System.out.println(contatos);
                        enviaStr.println(msgRecebida.getPessoa().toString());
                        
                    }
                    
                    else if(msgRecebida.getOpcao().equalsIgnoreCase("imprimir")){
                        enviaStr.println(contatos);
                    }
                    else
                    {               
                        nicks.remove(msgRecebida.getPessoa().getApelido());
                        System.out.println(nicks);
                        recebeObj.close();
                        enviaStr.close();
                        cSocket.close();
                        break;
                    }
                }                
            } catch (Exception ex) {
                System.err.println("Erro comunicação: "+ex.getMessage());
                System.exit(0);
            } 
    }
}
