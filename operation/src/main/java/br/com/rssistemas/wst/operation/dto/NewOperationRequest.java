package br.com.rssistemas.wst.operation.dto;

import br.com.rssistemas.wst.operation.entities.Operation;
import br.com.rssistemas.wst.operation.enums.Country;
import br.com.rssistemas.wst.operation.enums.Type;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NewOperationRequest {

    @NotBlank
    private String name;

    @NotNull
    private Country country;

    @NotNull
    private Type type;

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public Type getType() {
        return type;
    }

    public Operation toModel() {
        return new Operation(name, country, type);
    }
}
