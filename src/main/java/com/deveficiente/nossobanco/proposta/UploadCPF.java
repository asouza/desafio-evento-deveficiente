package com.deveficiente.nossobanco.proposta;

import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class UploadCPF {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String frente;
    private String verso;

    @Deprecated
    protected UploadCPF() {
    }

    public UploadCPF(@NotNull @URL String frente, @URL @NotNull String verso) {
        this.frente = frente;
        this.verso = verso;
    }

    public Long getId() {
        return id;
    }

    public String getFrente() {
        return frente;
    }

    public String getVerso() {
        return verso;
    }
}
