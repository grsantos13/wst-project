package br.com.rssistemas.wst.deliveryplace.dto;

import br.com.rssistemas.wst.deliveryplace.entities.DeliveryPlace;
import br.com.rssistemas.wst.deliveryplace.validations.annotation.Unique;

import javax.validation.constraints.NotBlank;

public class NewDeliveryPlaceRequest {
    @NotBlank
    @Unique(field = "name", domainClass = DeliveryPlace.class)
    private String name;

    public String getName() {
        return name;
    }
}
