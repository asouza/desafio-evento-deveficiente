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
}
