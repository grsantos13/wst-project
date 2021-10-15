package br.com.rssistemas.wst.operation.services;

import br.com.rssistemas.wst.operation.dto.NewProcessRequest;
import br.com.rssistemas.wst.operation.dto.ProcessResponse;
import br.com.rssistemas.wst.operation.dto.UpdateProcessResponsibleRequest;
import br.com.rssistemas.wst.operation.repositories.ProcessRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.UUID;

@Service
public class ProcessWriteOnlyServiceImpl implements ProcessWriteOnlyService {

    private final ProcessRepository repository;
    private final EntityManager manager;

    public ProcessWriteOnlyServiceImpl(ProcessRepository repository, EntityManager manager) {
        this.repository = repository;
        this.manager = manager;
    }

    @Override
    public ProcessResponse create(NewProcessRequest request) {
        return null;
    }

    @Override
    public ProcessResponse updateResponsible(UUID id, UpdateProcessResponsibleRequest request) {
        return null;
    }
}
