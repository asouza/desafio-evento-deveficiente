package com.deveficiente.nossobanco.proposta;

import com.deveficiente.nossobanco.compartilhado.BeforeDate;
import com.deveficiente.nossobanco.compartilhado.UniqueValue;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class NovaPropostaRequest {
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @CPF
    @NotNull
    @UniqueValue(domainClass = Proposta.class, fieldName = "cpf")
    private String cpf;
    @NotBlank
    @Email
    @UniqueValue(domainClass = Proposta.class, fieldName = "email")
    private String email;
    @Past
    @NotNull
    @BeforeDate(years = 18)
    private LocalDate dataNascimento;

    public NovaPropostaRequest(@NotBlank String nome, @NotBlank String sobrenome, @CPF @NotNull String cpf, @NotBlank @Email String email, @Past @NotNull LocalDate dataNascimento) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public Proposta toModel() {
        return new Proposta(nome, sobrenome, cpf, email, dataNascimento);
    }
}
