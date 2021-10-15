package br.com.rssistemas.wst.operation.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.UUID;

public class NewProcessRequest {
    @NotBlank
    private String name;

    @NotNull
    private UUID operationId;

    @NotNull
    @Size(min = 1)
    private Set<UUID> responsibleIds;

    public String getName() {
        return name;
    }

    public UUID getOperationId() {
        return operationId;
    }

    public Set<UUID> getResponsibleIds() {
        return responsibleIds;
    }
}
