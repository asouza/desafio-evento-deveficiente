package com.deveficiente.nossobanco.proposta;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class NovaPropostaRequest {
    @NotEmpty
    private String nome;
    @NotEmpty
    private String sobrenome;
    @NotEmpty
    @Email
    private String email;//TODO: unique
    @Past
    @NotNull
    private LocalDate dataNascimento;//TODO: 18 anos

}
