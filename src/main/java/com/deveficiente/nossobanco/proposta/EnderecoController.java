package com.deveficiente.nossobanco.proposta;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController()
public class EnderecoController {
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PropostaRepository propostaRepository;

	@PostMapping("/api/proposta/{id}/parte-2")
	public ResponseEntity parte(@RequestBody @Valid EnderecoPropostaRequest request, @PathVariable("id") Long id,
								UriComponentsBuilder uriComponentsBuilder) {
		Endereco novoEndereco = request.toModel();
		Proposta proposta = Optional.ofNullable(propostaRepository.getOne(id))
				.orElseThrow(() -> new IllegalArgumentException("Id da proposta nao existe"));
		proposta.adicionaEndereco(novoEndereco);
		propostaRepository.save(proposta);
		URI uri = uriComponentsBuilder.path("/api/proposta/{id}/parte-3").buildAndExpand(id).toUri();
		return ResponseEntity.created(uri).build();
	}
}
