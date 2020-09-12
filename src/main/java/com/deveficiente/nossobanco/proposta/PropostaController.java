package com.deveficiente.nossobanco.proposta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;
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

        final URI uri = uriComponentsBuilder.path("/api/proposta/{id}/parte-2").buildAndExpand(proposta.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropostaResponse> proposta(@PathVariable Long id) {
        Optional<Proposta> proposta = propostaRepository.findById(id);

        if(proposta.isPresent()) {
            PropostaResponse propostaResponse = new PropostaResponse(proposta.get());
            return ResponseEntity.ok(propostaResponse);
        }

        return null;
    }

}