package br.com.rssistemas.wst.deliveryplace.repositories;

import br.com.rssistemas.wst.deliveryplace.entities.DeliveryPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DeliveryPlaceRepository extends JpaRepository<DeliveryPlace, UUID> {
}
