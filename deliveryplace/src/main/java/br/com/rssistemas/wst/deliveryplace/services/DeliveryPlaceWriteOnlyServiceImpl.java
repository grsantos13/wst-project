package br.com.rssistemas.wst.deliveryplace.services;

import br.com.rssistemas.wst.deliveryplace.dto.DeliveryPlaceResponse;
import br.com.rssistemas.wst.deliveryplace.dto.NewDeliveryPlaceRequest;
import br.com.rssistemas.wst.deliveryplace.entities.DeliveryPlace;
import br.com.rssistemas.wst.deliveryplace.repositories.DeliveryPlaceRepository;
import org.springframework.stereotype.Service;

@Service
public class DeliveryPlaceWriteOnlyServiceImpl implements DeliveryPlaceWriteOnlyService {

    private final DeliveryPlaceRepository repository;

    public DeliveryPlaceWriteOnlyServiceImpl(DeliveryPlaceRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeliveryPlaceResponse create(NewDeliveryPlaceRequest request) {
        DeliveryPlace deliveryPlace = toModel(request);
        repository.save(deliveryPlace);
        return new DeliveryPlaceResponse(deliveryPlace);
    }

    private DeliveryPlace toModel(NewDeliveryPlaceRequest request) {
        return new DeliveryPlace(request.getName());
    }
}
