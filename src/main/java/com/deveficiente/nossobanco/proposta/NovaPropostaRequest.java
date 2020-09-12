package com.deveficiente.nossobanco.proposta;

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
  private String cpf; //TODO unique
  @NotBlank
  @Email
  private String email;//TODO: unique
  @Past
  @NotNull
  private LocalDate dataNascimento;//TODO: 18 anos

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSobrenome() {
    return sobrenome;
  }

  public void setSobrenome(String sobrenome) {
    this.sobrenome = sobrenome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public Proposta toModel() {
    return new Proposta(nome, sobrenome, cpf, email, dataNascimento);
  }
}
