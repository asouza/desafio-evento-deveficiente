package com.deveficiente.nossobanco.proposta;

import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotNull;

public class Upload {

  private final String frente;
  private final String verso;

  public Upload(@NotNull @URL String frente, @URL @NotNull String verso) {
    this.frente = frente;
    this.verso = verso;
  }
}
