package com.deveficiente.nossobanco.proposta;

import javax.validation.constraints.NotBlank;

public class Parte2Request {
	@NotBlank
	private String cep;
	@NotBlank
	private String rua;
	@NotBlank
	private String bairro;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotBlank
	private String estado;
	public Parte2Request(@NotBlank String cep, @NotBlank String rua, @NotBlank String bairro,
			@NotBlank String complemento, @NotBlank String cidade, @NotBlank String estado) {
		this.cep = cep;
		this.rua = rua;
		this.bairro = bairro;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public Endereco toModel() {
		return new Endereco(this.bairro,this.cep,this.cidade,this.complemento,this.estado,this.rua);
	}
}
