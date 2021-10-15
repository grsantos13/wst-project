package br.com.rssistemas.wst.operation.dto;

import br.com.rssistemas.wst.operation.entities.Process;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class ProcessResponse {
    private UUID id;
    private String name;
    private String operation;
    private Set<String> responsible;

    public ProcessResponse(Process process) {
        this.id = process.getId();
        this.name = process.getName();
        this.operation = process.getOperation().getName();
        this.responsible = process.getResponsible().stream().map(String::new).collect(Collectors.toSet());
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOperation() {
        return operation;
    }

    public Set<String> getResponsible() {
        return responsible;
    }
}
