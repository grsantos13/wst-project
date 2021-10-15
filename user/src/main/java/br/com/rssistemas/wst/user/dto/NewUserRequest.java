package br.com.rssistemas.wst.user.dto;

import br.com.rssistemas.wst.user.entities.User;
import br.com.rssistemas.wst.user.enums.Position;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NewUserRequest {

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @NotNull
    private Position position;

    private String extension;

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

    public User toModel(){
        return new User(name, email, extension, position);
    }
}
