package br.com.rssistemas.wst.exporter.dto;

import br.com.rssistemas.wst.exporter.entities.Address;
import br.com.rssistemas.wst.exporter.entities.Exporter;
import br.com.rssistemas.wst.exporter.enums.Currency;
import br.com.rssistemas.wst.exporter.enums.Incoterm;
import br.com.rssistemas.wst.exporter.enums.PaymentTerms;

import java.util.UUID;

public class ExporterResponse {
    private final UUID id;
    private final String code;
    private final String name;
    private final PaymentTerms paymentTerms;
    private final Address address;
    private final Incoterm incoterm;
    private final Currency currency;

    public ExporterResponse(Exporter exporter) {
        this.id = exporter.getId();
        this.code = exporter.getCode();
        this.name = exporter.getName();
        this.paymentTerms = exporter.getPaymentTerms();
        this.address = exporter.getAddress();
        this.incoterm = exporter.getIncoterm();
        this.currency = exporter.getCurrency();
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
}
