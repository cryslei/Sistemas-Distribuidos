package classes;

import java.io.Serializable;

public class Pessoa implements Serializable{
    private String nome;
    private int cpf;
    private int telefone;
    private String apelido;
    
    public Pessoa() {
    }

    public Pessoa(String nome, int cpf, int telefone, String apelido) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.apelido = apelido;
        
    }
    
    public String getNome() { 
        return nome;
    }
    
    public String getApelido() {
       return apelido;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return cpf;
    }
    
    public int getTelefone() {
        return telefone;
    }

    public void setIdade(int cpf) {
        this.cpf = cpf;
    }
    
    
    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone +'}';
    }
}
