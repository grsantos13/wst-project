package br.com.rssistemas.wst.exporter.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "unregisteredExporter_code_uk", columnNames = {"code"})
})
public class UnregisteredExporter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank
    @Size(min = 8, max = 8)
    @Column(nullable = false, unique = true, updatable = false)
    private String code;
}
