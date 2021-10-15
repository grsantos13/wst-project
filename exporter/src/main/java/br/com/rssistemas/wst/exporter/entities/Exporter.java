package br.com.rssistemas.wst.exporter.entities;

import br.com.rssistemas.wst.exporter.dto.UpdateExporterRequest;
import br.com.rssistemas.wst.exporter.enums.Currency;
import br.com.rssistemas.wst.exporter.enums.Incoterm;
import br.com.rssistemas.wst.exporter.enums.PaymentTerms;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "exporter_code_uk", columnNames = {"code"})
})
public class Exporter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank
    @Size(min = 8, max = 8)
    @Column(nullable = false, unique = true, updatable = false)
    private String code;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentTerms paymentTerms;

    @Valid
    @NotNull
    @Embedded
    private Address address;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Incoterm incoterm;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Deprecated
    public Exporter() {
    }

    public Exporter(String code, String name, PaymentTerms paymentTerms, Address address, Incoterm incoterm, Currency currency) {
        this.code = code;
        this.name = name;
        this.paymentTerms = paymentTerms;
        this.address = address;
        this.incoterm = incoterm;
        this.currency = currency;
    }

    public UUID getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public PaymentTerms getPaymentTerms() {
        return paymentTerms;
    }

    public Address getAddress() {
        return address;
    }

    public Incoterm getIncoterm() {
        return incoterm;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void update(UpdateExporterRequest request) {
        this.address = request.getAddress();
        this.incoterm = request.getIncoterm();
        this.paymentTerms = request.getPaymentTerms();
        this.name = request.getName();
    }
}
