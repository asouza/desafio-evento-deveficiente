package com.deveficiente.nossobanco.proposta;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank String bairro;
	private @NotBlank String cep;
	private @NotBlank String cidade;
	private @NotBlank String complemento;
	private @NotBlank String estado;
	private @NotBlank String rua;

	public Endereco(@NotBlank String bairro, @NotBlank String cep,
			@NotBlank String cidade, @NotBlank String complemento,
			@NotBlank String estado, @NotBlank String rua) {
				this.bairro = bairro;
				this.cep = cep;
				this.cidade = cidade;
				this.complemento = complemento;
				this.estado = estado;
				this.rua = rua;
		// TODO Auto-generated constructor stub
	}

}
