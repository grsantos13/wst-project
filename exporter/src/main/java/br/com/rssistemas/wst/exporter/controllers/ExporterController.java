package br.com.rssistemas.wst.exporter.controllers;

import br.com.rssistemas.wst.exporter.dto.ExporterResponse;
import br.com.rssistemas.wst.exporter.dto.NewExporterRequest;
import br.com.rssistemas.wst.exporter.dto.UpdateExporterRequest;
import br.com.rssistemas.wst.exporter.services.ExporterWriteOnlyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/exporters")
public class ExporterController {

    private final ExporterWriteOnlyService writeOnlyService;

    public ExporterController(ExporterWriteOnlyService writeOnlyService) {
        this.writeOnlyService = writeOnlyService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@Valid @RequestBody NewExporterRequest request, UriComponentsBuilder uriComponentsBuilder) {
        ExporterResponse response = writeOnlyService.create(request);
        URI uri = uriComponentsBuilder.path("/exporters/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<?> update(@Valid @RequestBody UpdateExporterRequest request, @PathVariable("id") UUID id) {
        ExporterResponse response = writeOnlyService.update(id, request);
        return ResponseEntity.ok(response);
    }
}
