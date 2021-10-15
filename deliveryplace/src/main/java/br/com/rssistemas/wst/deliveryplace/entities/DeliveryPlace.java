package br.com.rssistemas.wst.deliveryplace.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "delivery_place_name_uk", columnNames = {"name"})
})
public class DeliveryPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @Deprecated
    public DeliveryPlace() {
    }

    public DeliveryPlace(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
