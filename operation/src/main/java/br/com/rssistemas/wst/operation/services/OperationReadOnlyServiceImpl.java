package br.com.rssistemas.wst.operation.services;

import br.com.rssistemas.wst.operation.dto.OperationResponse;
import br.com.rssistemas.wst.operation.entities.Operation;
import br.com.rssistemas.wst.operation.exceptions.NotFoundException;
import br.com.rssistemas.wst.operation.repositories.OperationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OperationReadOnlyServiceImpl implements OperationReadOnlyService {

    private final OperationRepository repository;

    public OperationReadOnlyServiceImpl(OperationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<OperationResponse> findAll() {
        return repository.findAll()
                .stream().map(OperationResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public OperationResponse findById(UUID id) {
        Operation operation = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Operação", "id", id.toString()));
        return new OperationResponse(operation);
    }
}
