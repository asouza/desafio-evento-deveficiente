package com.deveficiente.nossobanco.proposta;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class ContinuacaoPropostaCOntroller {
	public String parte(@RequestBody @Valid Parte2Request request) {
		return "part 2...";
	}
}
