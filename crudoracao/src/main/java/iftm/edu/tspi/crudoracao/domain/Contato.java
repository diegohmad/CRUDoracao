package iftm.edu.tspi.crudoracao.domain;
import lombok.Data;

@Data
public class Contato {
    
    private Integer id;
    private String nome;
    private String sobrenome;
    private String celular;
    private String email;

    public Contato() {
        
    }
    public Contato(Integer id, String nome, String sobrenome, String celular, String email) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.celular = celular;
        this.email = email;
    }

}

