package br.com.rssistemas.wst.exporter.services;

import br.com.rssistemas.wst.exporter.dto.ExporterResponse;
import br.com.rssistemas.wst.exporter.dto.NewExporterRequest;
import br.com.rssistemas.wst.exporter.dto.UpdateExporterRequest;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Validated
public interface ExporterWriteOnlyService {
    ExporterResponse create (@Valid NewExporterRequest request);
    ExporterResponse update (@NotNull UUID id, @Valid UpdateExporterRequest request);
}
