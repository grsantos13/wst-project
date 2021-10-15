package br.com.rssistemas.wst.operation.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.UUID;

public class UpdateProcessResponsibleRequest {
    @NotNull
    @Size(min = 1)
    private Set<UUID> responsibleIds;

    public Set<UUID> getResponsibleIds() {
        return responsibleIds;
    }
}
