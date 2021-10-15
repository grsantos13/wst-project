package br.com.rssistemas.wst.exporter.dto;

import br.com.rssistemas.wst.exporter.entities.Address;
import br.com.rssistemas.wst.exporter.enums.Incoterm;
import br.com.rssistemas.wst.exporter.enums.PaymentTerms;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdateExporterRequest {
    @NotBlank
    private String name;

    @NotNull
    private PaymentTerms paymentTerms;

    @Valid
    @NotNull
    private Address address;

    @NotNull
    private Incoterm incoterm;

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
}
