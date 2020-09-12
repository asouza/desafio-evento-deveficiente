package com.deveficiente.nossobanco.proposta;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.util.Assert;

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
    @OneToOne(cascade = CascadeType.MERGE)
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.MERGE)
    private UploadCPF uploadCPF;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Proposta() {
    }


    public Proposta(String nome, String sobrenome, String cpf, String email, LocalDate dataNascimento) {

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public void adicionaEndereco(Endereco novoEndereco) {
        Assert.isNull(this.endereco, "O endereço tem que ser nulo para ser um novo");
        this.endereco = novoEndereco;
    }

    public void adicionaCpfUpload(UploadCPF uploadCPF) {
        Assert.isNull(this.uploadCPF, "O upload tem que ser nulo para ser um novo");
        this.uploadCPF = uploadCPF;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public UploadCPF getUploadCPF() {
        return uploadCPF;
    }

    public boolean isCompleto() {
        return false;
    }
}
