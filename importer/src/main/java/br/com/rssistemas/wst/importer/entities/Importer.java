package br.com.rssistemas.wst.importer.entities;

import br.com.rssistemas.wst.importer.dto.UpdateImporterRequest;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "importer_plant_uk", columnNames = {"plant"})
})
public class Importer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Valid
    @NotNull
    @Embedded
    private Address address;

    @NotBlank
    @Column(nullable = false, updatable = false)
    private String plant;

    @NotBlank
    @Column(nullable = false, updatable = false)
    private String fiscalName;

    @NotBlank
    @Column(nullable = false, updatable = false)
    private String fiscalNumber;

    @Deprecated
    public Importer() {
    }

    public Importer(Address address, String plant, String fiscalName, String fiscalNumber) {
        this.address = address;
        this.plant = plant;
        this.fiscalName = fiscalName;
        this.fiscalNumber = fiscalNumber;
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

    public void update(UpdateImporterRequest request) {
        this.address = request.getAddress();
        this.fiscalName = request.getFiscalName();
    }
}
