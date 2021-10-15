package br.com.rssistemas.wst.operation.controllers;

import br.com.rssistemas.wst.operation.dto.NewProcessRequest;
import br.com.rssistemas.wst.operation.dto.ProcessResponse;
import br.com.rssistemas.wst.operation.dto.UpdateProcessResponsibleRequest;
import br.com.rssistemas.wst.operation.services.ProcessWriteOnlyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/processes")
public class ProcessController {

    private final ProcessWriteOnlyService service;

    public ProcessController(ProcessWriteOnlyService service) {
        this.service = service;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@Valid @RequestBody NewProcessRequest request, UriComponentsBuilder uriBuilder) {
        ProcessResponse response = this.service.create(request);
        URI uri = uriBuilder.path("/processes/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<?> updateResponsible(@Valid @RequestBody UpdateProcessResponsibleRequest request,
                                               @PathVariable("id") UUID id) {
        ProcessResponse response = this.service.updateResponsible(id, request);
        return ResponseEntity.ok(response);
    }
}
