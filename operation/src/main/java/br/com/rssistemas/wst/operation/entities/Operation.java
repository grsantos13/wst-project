package br.com.rssistemas.wst.operation.entities;

import br.com.rssistemas.wst.operation.enums.Country;
import br.com.rssistemas.wst.operation.enums.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Country country;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @OneToMany(mappedBy = "operation", fetch = FetchType.EAGER)
    private List<Process> processes = new ArrayList<>();

    @Deprecated
    public Operation() {
    }

    public Operation(String name,
                     Country country,
                     Type type) {
        this.name = name;
        this.country = country;
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public Type getType() {
        return type;
    }

    public List<Process> getProcesses() {
        return processes;
    }
}
