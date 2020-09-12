package com.deveficiente.nossobanco.proposta;

import java.time.LocalDate;

public class PropostaResponse {

    public final Long id;

    public final String nome;

    public final String sobrenome;

    public final String cpf;

    public final String email;

    public final LocalDate dataNascimento;
    public final EnderecoResponse endereco;

    public final UploadCPFResponse uploadCPF;

    public PropostaResponse(Proposta proposta) {
        this.id = proposta.getId();
        this.nome = proposta.getNome();
        this.sobrenome = proposta.getSobrenome();
        this.cpf = proposta.getCpf();
        this.email = proposta.getEmail();
        this.dataNascimento = proposta.getDataNascimento();
        this.endereco = new EnderecoResponse(proposta.getEndereco());
        this.uploadCPF = new UploadCPFResponse(proposta.getUploadCPF());
    }
}

class EnderecoResponse {
    public final String bairro;
    public final String cep;
    public final String cidade;
    public final String complemento;
    public final String estado;
    public final String rua;

    EnderecoResponse(Endereco endereco) {
        this.bairro = endereco.getBairro();
        this.cep = endereco.getCep();
        this.cidade = endereco.getCidade();
        this.complemento = endereco.getComplemento();
        this.estado = endereco.getEstado();
        this.rua = endereco.getRua();
    }
}

class UploadCPFResponse {
    public final String frente;
    public final String verso;

    UploadCPFResponse(UploadCPF uploadCPF) {
        this.frente = uploadCPF.getFrente();
        this.verso = uploadCPF.getVerso();
    }
}