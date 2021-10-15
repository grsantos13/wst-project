package br.com.rssistemas.wst.exporter.services;

import br.com.rssistemas.wst.exporter.dto.ExporterResponse;
import br.com.rssistemas.wst.exporter.dto.NewExporterRequest;
import br.com.rssistemas.wst.exporter.dto.UpdateExporterRequest;
import br.com.rssistemas.wst.exporter.entities.Exporter;
import br.com.rssistemas.wst.exporter.repositories.ExporterRepository;
import br.com.rssistemas.wst.exporter.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExporterWriteOnlyServiceImpl implements ExporterWriteOnlyService {

    private final ExporterRepository repository;

    public ExporterWriteOnlyServiceImpl(ExporterRepository repository) {
        this.repository = repository;
    }

    @Override
    public ExporterResponse create(NewExporterRequest request) {
        Exporter exporter = toModel(request);
        repository.save(exporter);
        return new ExporterResponse(exporter);
    }

    @Override
    public ExporterResponse update(UUID id, UpdateExporterRequest request) {
        Exporter exporter = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Exportador", "id", id.toString()));

        exporter.update(request);
        repository.save(exporter);
        return new ExporterResponse(exporter);
    }

    private Exporter toModel(NewExporterRequest request) {
        return new Exporter(request.getCode(),
                request.getName(),
                request.getPaymentTerms(),
                request.getAddress(),
                request.getIncoterm(),
                request.getCurrency());
    }
}
