package br.com.rssistemas.wst.user.controllers;

import br.com.rssistemas.wst.user.dto.NewUserRequest;
import br.com.rssistemas.wst.user.dto.UpdateUserRequest;
import br.com.rssistemas.wst.user.dto.UserResponse;
import br.com.rssistemas.wst.user.services.UserWriteOnlyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserWriteOnlyService service;

    public UserController(UserWriteOnlyService service) {
        this.service = service;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@RequestBody @Valid NewUserRequest request, UriComponentsBuilder uriBuilder) {
        UserResponse userResponse = service.create(request);
        URI uri = uriBuilder.path("/users/{id}")
                .buildAndExpand(userResponse.getId())
                .toUri();
        return ResponseEntity.created(uri).body(userResponse);
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<?> update(@RequestBody @Valid UpdateUserRequest request,
                                    @PathVariable("id") UUID id) {

        return ResponseEntity.ok(service.update(id, request));
    }
}
