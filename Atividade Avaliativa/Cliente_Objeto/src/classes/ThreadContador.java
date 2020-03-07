/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Madianita
 */
public class ThreadContador extends Thread
{
        javax.swing.JLabel lbCont;
        int cont = 0;
        
        public ThreadContador(javax.swing.JLabel lbCont)
        {
            this.lbCont = lbCont;
        }

        @Override
       public void run() {

           for(;;){
               
               lbCont.setText(cont+"");
               cont++;
               
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException ex) {
                   Logger.getLogger(ThreadContador.class.getName()).log(Level.SEVERE, null, ex);
               }
           }

       }
}

