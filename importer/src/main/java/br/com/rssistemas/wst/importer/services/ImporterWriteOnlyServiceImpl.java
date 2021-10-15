package br.com.rssistemas.wst.importer.services;

import br.com.rssistemas.wst.importer.dto.ImporterResponse;
import br.com.rssistemas.wst.importer.dto.NewImporterRequest;
import br.com.rssistemas.wst.importer.dto.UpdateImporterRequest;
import br.com.rssistemas.wst.importer.entities.Importer;
import br.com.rssistemas.wst.importer.repositories.ImporterRepository;
import br.com.rssistemas.wst.importer.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ImporterWriteOnlyServiceImpl implements ImporterWriteOnlyService {

    private final ImporterRepository repository;

    public ImporterWriteOnlyServiceImpl(ImporterRepository repository) {
        this.repository = repository;
    }

    @Override
    public ImporterResponse create(NewImporterRequest request) {
        Importer importer = toModel(request);
        repository.save(importer);
        return new ImporterResponse(importer);
    }

    @Override
    public ImporterResponse update(UUID id, UpdateImporterRequest request) {
        Importer importer = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Importador", "id", id.toString()));

        importer.update(request);
        repository.save(importer);
        return new ImporterResponse(importer);
    }

    private Importer toModel(NewImporterRequest request) {
        return new Importer(request.getAddress(),
                request.getPlant(),
                request.getFiscalName(),
                request.getFiscalNumber());
    }
}
