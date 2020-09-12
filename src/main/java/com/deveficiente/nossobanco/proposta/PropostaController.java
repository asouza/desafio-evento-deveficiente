package com.deveficiente.nossobanco.proposta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/proposta")
public class PropostaController {

  @Autowired
  private PropostaRepository propostaRepository;

  @PostMapping
  public ResponseEntity cadastrar(@RequestBody @Valid NovaPropostaRequest novaProposta, UriComponentsBuilder uriComponentsBuilder) {
    final Proposta proposta = novaProposta.toModel();
    propostaRepository.save(proposta);

    final URI uri = uriComponentsBuilder.path("/api/proposta" + proposta.getId()).build().toUri();
    return ResponseEntity.created(uri).build();
  }
}