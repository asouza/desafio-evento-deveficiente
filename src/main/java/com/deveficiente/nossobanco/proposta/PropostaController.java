package com.deveficiente.nossobanco.proposta;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/proposta")
public class PropostaController {

  @PostMapping
  public ResponseEntity<Long> cadastrar(@RequestBody @Valid NovaPropostaRequest novaProposta) {
    final Proposta proposta = novaProposta.toModel();
    return ResponseEntity.ok(proposta.getId());
  }
}
