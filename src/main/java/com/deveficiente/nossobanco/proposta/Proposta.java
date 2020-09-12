package com.deveficiente.nossobanco.proposta;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Proposta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String sobrenome;

    private String cpf;

    private String email;

    private LocalDate dataNascimento;


    public Proposta() {
    }

    public Proposta(String nome, String sobrenome, String cpf, String email, LocalDate dataNascimento) {

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }
}
