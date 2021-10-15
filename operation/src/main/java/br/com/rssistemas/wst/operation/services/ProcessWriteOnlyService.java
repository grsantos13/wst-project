package br.com.rssistemas.wst.operation.services;

import br.com.rssistemas.wst.operation.dto.NewProcessRequest;
import br.com.rssistemas.wst.operation.dto.ProcessResponse;
import br.com.rssistemas.wst.operation.dto.UpdateProcessResponsibleRequest;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.UUID;

@Validated
public interface ProcessWriteOnlyService {
    ProcessResponse create(@Valid NewProcessRequest request);
    ProcessResponse updateResponsible(UUID id, @Valid UpdateProcessResponsibleRequest request);
}
