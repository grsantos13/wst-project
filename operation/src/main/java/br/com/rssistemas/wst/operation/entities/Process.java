package br.com.rssistemas.wst.operation.entities;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.UUID;

@Entity
@Table
public class Process {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @Valid
    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false)
    private Operation operation;

    @Valid
    @Size(min = 1)
    @NotNull
    @ElementCollection
    private Set<String> responsible;

    @Deprecated
    public Process() {
    }

    public Process(String name, Operation operation, Set<String> responsible) {
        this.name = name;
        this.operation = operation;
        this.responsible = responsible;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Operation getOperation() {
        return operation;
    }

    public Set<String> getResponsible() {
        return responsible;
    }

    public void updateResponsible(Set<String> responsible) {
        this.responsible = responsible;
    }
}
