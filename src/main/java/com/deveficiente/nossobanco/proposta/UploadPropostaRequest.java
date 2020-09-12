package com.deveficiente.nossobanco.proposta;

import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotNull;

public class UploadPropostaRequest {

  @NotNull
  @URL
  private String frente;

  @URL
  @NotNull
  private String verso;

  public UploadPropostaRequest(@NotNull @URL String frente, @URL @NotNull String verso) {
    this.frente = frente;
    this.verso = verso;
  }

  public UploadCPF toModel(){
    return new UploadCPF(this.frente, this.verso);
  }


}
