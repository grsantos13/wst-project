package br.com.rssistemas.wst.importer.dto;

import br.com.rssistemas.wst.importer.entities.Address;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NewImporterRequest {

    @Valid
    @NotNull
    private Address address;

    @NotBlank
    private String plant;

    @NotBlank
    private String fiscalName;

    @NotBlank
    private String fiscalNumber;

    public Address getAddress() {
        return address;
    }

    public String getPlant() {
        return plant;
    }

    public String getFiscalName() {
        return fiscalName;
    }

    public String getFiscalNumber() {
        return fiscalNumber;
    }
}
