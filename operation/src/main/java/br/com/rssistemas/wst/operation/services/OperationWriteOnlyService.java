package br.com.rssistemas.wst.operation.services;

import br.com.rssistemas.wst.operation.dto.NewOperationRequest;
import br.com.rssistemas.wst.operation.dto.OperationResponse;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
public interface OperationWriteOnlyService {
    OperationResponse create(@Valid NewOperationRequest request);
}
