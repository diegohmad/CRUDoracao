package iftm.edu.tspi.crudoracao.domain;
import lombok.Data;

@Data
public class Contato {
    
    private String nome;
    private String sobrenome;
    private String celular;
    private String email;

    public Contato() {
        
    }
    public Contato(String nome, String sobrenome, String celular, String email) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.celular = celular;
        this.email = email;
    }

}

