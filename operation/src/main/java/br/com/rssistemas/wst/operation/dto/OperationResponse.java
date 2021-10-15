package br.com.rssistemas.wst.operation.dto;

import br.com.rssistemas.wst.operation.entities.Operation;
import br.com.rssistemas.wst.operation.enums.Country;
import br.com.rssistemas.wst.operation.enums.Type;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class OperationResponse {
    private UUID id;
    private String name;
    private Country country;
    private Type type;
    private List<ProcessResponse> processes;


    public OperationResponse(Operation operation) {
        this.id = operation.getId();
        this.name = operation.getName();
        this.country = operation.getCountry();
        this.type = operation.getType();
        this.processes = operation.getProcesses()
                .stream().map(ProcessResponse::new)
                .collect(Collectors.toList());
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public Type getType() {
        return type;
    }

    public List<ProcessResponse> getProcesses() {
        return processes;
    }
}
