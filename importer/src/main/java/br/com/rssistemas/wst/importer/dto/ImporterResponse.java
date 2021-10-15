package br.com.rssistemas.wst.importer.dto;

import br.com.rssistemas.wst.importer.entities.Address;
import br.com.rssistemas.wst.importer.entities.Importer;

import java.util.UUID;

public class ImporterResponse {
    private UUID id;
    private Address address;
    private String plant;
    private String fiscalName;
    private String fiscalNumber;

    public ImporterResponse(Importer importer) {
        this.id = importer.getId();
        this.address = importer.getAddress();
        this.plant = importer.getPlant();
        this.fiscalName = importer.getFiscalName();
        this.fiscalNumber = importer.getFiscalNumber();
    }

    public UUID getId() {
        return id;
    }

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
