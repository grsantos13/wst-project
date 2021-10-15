package br.com.rssistemas.wst.user.services;

import br.com.rssistemas.wst.user.dto.NewUserRequest;
import br.com.rssistemas.wst.user.dto.UpdateUserRequest;
import br.com.rssistemas.wst.user.dto.UserResponse;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.UUID;

@Validated
public interface UserWriteOnlyService {
    UserResponse create(@Valid NewUserRequest request);

    UserResponse update(UUID id, @Valid UpdateUserRequest request);
}
