package br.com.rssistemas.wst.operation.services;

import br.com.rssistemas.wst.operation.dto.OperationResponse;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Validated
public interface OperationReadOnlyService {
    List<OperationResponse> findAll();
    OperationResponse findById(@NotNull UUID id);
}
