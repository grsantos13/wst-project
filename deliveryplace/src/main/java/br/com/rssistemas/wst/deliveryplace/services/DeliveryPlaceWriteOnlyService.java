package br.com.rssistemas.wst.deliveryplace.services;

import br.com.rssistemas.wst.deliveryplace.dto.DeliveryPlaceResponse;
import br.com.rssistemas.wst.deliveryplace.dto.NewDeliveryPlaceRequest;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
public interface DeliveryPlaceWriteOnlyService {

    DeliveryPlaceResponse create(@Valid NewDeliveryPlaceRequest request);

}
