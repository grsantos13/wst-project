package br.com.rssistemas.wst.operation.services;

import br.com.rssistemas.wst.operation.dto.NewOperationRequest;
import br.com.rssistemas.wst.operation.dto.OperationResponse;
import br.com.rssistemas.wst.operation.entities.Operation;
import br.com.rssistemas.wst.operation.repositories.OperationRepository;
import org.springframework.stereotype.Service;

@Service
public class OperationWriteOnlyServiceImpl implements OperationWriteOnlyService {

    private final OperationRepository repository;

    public OperationWriteOnlyServiceImpl(OperationRepository repository) {
        this.repository = repository;
    }

    @Override
    public OperationResponse create(NewOperationRequest request) {
        Operation operation = request.toModel();
        repository.save(operation);
        return new OperationResponse(operation);
    }
}
