package br.com.rssistemas.wst.importer.controllers;

import br.com.rssistemas.wst.importer.dto.ImporterResponse;
import br.com.rssistemas.wst.importer.dto.NewImporterRequest;
import br.com.rssistemas.wst.importer.dto.UpdateImporterRequest;
import br.com.rssistemas.wst.importer.services.ImporterWriteOnlyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/importers")
public class ImporterController {

    private final ImporterWriteOnlyService writeOnlyService;

    public ImporterController(ImporterWriteOnlyService writeOnlyService) {
        this.writeOnlyService = writeOnlyService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@Valid @RequestBody NewImporterRequest request, UriComponentsBuilder uriComponentsBuilder) {
        ImporterResponse response = writeOnlyService.create(request);
        URI uri = uriComponentsBuilder.path("/importers/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<?> update(@Valid @RequestBody UpdateImporterRequest request, @PathVariable("id") UUID id) {
        ImporterResponse response = writeOnlyService.update(id, request);
        return ResponseEntity.ok(response);
    }
}
