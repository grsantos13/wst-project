package br.com.rssistemas.wst.importer.dto;

import br.com.rssistemas.wst.importer.entities.Address;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdateImporterRequest {
    @Valid
    @NotNull
    private Address address;

    @NotBlank
    private String fiscalName;

    public Address getAddress() {
        return address;
    }

    public String getFiscalName() {
        return fiscalName;
    }
}
