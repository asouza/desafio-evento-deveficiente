package com.deveficiente.nossobanco.proposta;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class EnderecoController {
	@Autowired
	private EnderecoRepository enderecoRepository;

	public String parte(@RequestBody @Valid Parte2Request request) {
		Endereco novoEndereco = request.toModel();
		enderecoRepository.save(novoEndereco);
		
		return "part 2...";
	}
}
