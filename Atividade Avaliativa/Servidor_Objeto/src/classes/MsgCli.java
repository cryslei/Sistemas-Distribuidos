/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;

/**
 *
 * @author Madianita
 */
public class MsgCli implements Serializable{
    private Pessoa pessoa;
    private String opcao;
  

    public MsgCli() {
    }

    
    public MsgCli(Pessoa p, String opcao) {
        this.pessoa = p;
        this.opcao = opcao;
        
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getOpcao() {
        return opcao;
    }

    public void setOpcao(String opcao) {
        this.opcao = opcao;
    }

    @Override
    public String toString() {
        return "MsgCli{" + "p=" + pessoa + ", opcao=" + opcao + '}';
    }    
}
