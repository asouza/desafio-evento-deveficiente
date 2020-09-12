package com.deveficiente.nossobanco.proposta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
public class UploadController {

  @Autowired
  private PropostaRepository propostaRepository;

  @PostMapping("/api/proposta/{id}/parte-3")
  public ResponseEntity parte3(@RequestBody @Valid UploadPropostaRequest request, @PathVariable("id") Long id,
                              UriComponentsBuilder uriComponentsBuilder) {
    UploadCPF uploadCPF = request.toModel();
    Optional<Proposta> optionalProposta = propostaRepository.findById(id);
    if (optionalProposta.isPresent()) {
      Proposta proposta = optionalProposta.get();
      proposta.adicionaCpfUpload(uploadCPF);
      propostaRepository.save(proposta);
      URI uri = uriComponentsBuilder.path("/api/proposta/{id}/parte-4").buildAndExpand(id).toUri();
      return ResponseEntity.created(uri).build();
    }
    return ResponseEntity.notFound().build();
  }
}
