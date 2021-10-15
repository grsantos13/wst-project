package br.com.rssistemas.wst.user.entities;

import br.com.rssistemas.wst.user.dto.UpdateUserRequest;
import br.com.rssistemas.wst.user.enums.Position;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "user_email_uk", columnNames = {"email"})
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @Email
    @NotBlank
    @Column(nullable = false)
    private String email;

    @Column
    private String extension;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Position position;

    @Deprecated
    public User() {
    }

    public User(String name, String email, String extension, Position position) {
        this.name = name;
        this.email = email;
        this.extension = extension;
        this.position = position;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getExtension() {
        return extension;
    }

    public Position getPosition() {
        return position;
    }

    public void update(UpdateUserRequest request) {
        this.extension = request.getExtension();
    }
}
