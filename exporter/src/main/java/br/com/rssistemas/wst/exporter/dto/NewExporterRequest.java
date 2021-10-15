package br.com.rssistemas.wst.exporter.dto;

import br.com.rssistemas.wst.exporter.entities.Address;
import br.com.rssistemas.wst.exporter.enums.Currency;
import br.com.rssistemas.wst.exporter.enums.Incoterm;
import br.com.rssistemas.wst.exporter.enums.PaymentTerms;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NewExporterRequest {
    @NotBlank
    @Size(min = 8, max = 8)
    private String code;

    @NotBlank
    private String name;

    @NotNull
    private PaymentTerms paymentTerms;

    @Valid
    @NotNull
    private Address address;

    @NotNull
    private Incoterm incoterm;

    @NotNull
    private Currency currency;

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
}
