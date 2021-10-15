package br.com.rssistemas.wst.deliveryplace.dto;

import br.com.rssistemas.wst.deliveryplace.entities.DeliveryPlace;

import java.util.UUID;

public class DeliveryPlaceResponse {
    private UUID id;
    private String name;

    public DeliveryPlaceResponse(DeliveryPlace deliveryPlace) {
        this.id = deliveryPlace.getId();
        this.name = deliveryPlace.getName();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
