package br.com.rssistemas.wst.user.dto;

import br.com.rssistemas.wst.user.entities.User;
import br.com.rssistemas.wst.user.enums.Position;

import java.util.UUID;

public class UserResponse {
    private UUID id;
    private String name;
    private String email;
    private String extension;
    private Position position;

    public UserResponse(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.name = user.getName();
        this.extension = user.getExtension();
        this.position = user.getPosition();
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
}
