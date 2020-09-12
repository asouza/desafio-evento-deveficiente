package com.deveficiente.nossobanco.proposta;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class EnderecoController {
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PropostaRepository propostaRepository;

	@PostMapping("/api/proposta/{id}/parte-2")
	public String parte(@RequestBody @Valid EnderecoPropostaRequest request, @PathVariable("id") Long id) {
		Endereco novoEndereco = request.toModel();
		Proposta proposta = propostaRepository.getOne(id);
		proposta.adicionaEndereco(novoEndereco);
		propostaRepository.save(proposta);
		return "part 2...";
	}
}
