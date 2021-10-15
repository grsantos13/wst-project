package br.com.rssistemas.wst.importer.services;

import br.com.rssistemas.wst.importer.dto.ImporterResponse;
import br.com.rssistemas.wst.importer.dto.NewImporterRequest;
import br.com.rssistemas.wst.importer.dto.UpdateImporterRequest;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Validated
public interface ImporterWriteOnlyService {
    ImporterResponse create(@Valid NewImporterRequest request);
    ImporterResponse update(@NotNull UUID id, @Valid UpdateImporterRequest request);
}
