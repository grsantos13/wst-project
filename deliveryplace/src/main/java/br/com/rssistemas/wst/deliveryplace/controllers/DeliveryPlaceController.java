package br.com.rssistemas.wst.deliveryplace.controllers;

import br.com.rssistemas.wst.deliveryplace.dto.DeliveryPlaceResponse;
import br.com.rssistemas.wst.deliveryplace.dto.NewDeliveryPlaceRequest;
import br.com.rssistemas.wst.deliveryplace.services.DeliveryPlaceWriteOnlyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/delivery-places")
public class DeliveryPlaceController {

    private final DeliveryPlaceWriteOnlyService writeOnlyService;

    public DeliveryPlaceController(DeliveryPlaceWriteOnlyService writeOnlyService) {
        this.writeOnlyService = writeOnlyService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@RequestBody @Valid NewDeliveryPlaceRequest request, UriComponentsBuilder uriBuilder) {
        DeliveryPlaceResponse response = this.writeOnlyService.create(request);
        URI uri = uriBuilder.path("/delivery-places/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(uri).body(response);
    }
}
