package br.com.rssistemas.wst.operation.controllers;

import br.com.rssistemas.wst.operation.dto.NewOperationRequest;
import br.com.rssistemas.wst.operation.dto.OperationResponse;
import br.com.rssistemas.wst.operation.services.OperationReadOnlyService;
import br.com.rssistemas.wst.operation.services.OperationWriteOnlyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/operations")
public class OperationController {

    private final OperationWriteOnlyService writeService;
    private final OperationReadOnlyService readService;

    public OperationController(OperationWriteOnlyService service, OperationReadOnlyService readService) {
        this.writeService = service;
        this.readService = readService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@Valid @RequestBody NewOperationRequest request, UriComponentsBuilder uriBuilder) {
        OperationResponse operationResponse = this.writeService.create(request);
        URI uri = uriBuilder.path("/operations/{id}")
                .buildAndExpand(operationResponse.getId())
                .toUri();

        return ResponseEntity.created(uri).body(operationResponse);
    }

    @GetMapping
    public ResponseEntity<?> readAll() {
        return ResponseEntity.ok(this.readService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(this.readService.findById(id));
    }
}
