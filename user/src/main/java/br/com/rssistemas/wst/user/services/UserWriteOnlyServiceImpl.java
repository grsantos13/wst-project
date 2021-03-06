package br.com.rssistemas.wst.user.services;

import br.com.rssistemas.wst.user.dto.NewUserRequest;
import br.com.rssistemas.wst.user.dto.UpdateUserRequest;
import br.com.rssistemas.wst.user.dto.UserResponse;
import br.com.rssistemas.wst.user.entities.User;
import br.com.rssistemas.wst.user.exceptions.NotFoundException;
import br.com.rssistemas.wst.user.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserWriteOnlyServiceImpl implements UserWriteOnlyService {

    private final UserRepository repository;

    public UserWriteOnlyServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserResponse create(NewUserRequest request) {
        User user = request.toModel();
        repository.save(user);
        return new UserResponse(user);
    }

    @Override
    public UserResponse update(UUID id, UpdateUserRequest request) {
        User user = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário", "id", id.toString()));
        user.update(request);
        return new UserResponse(user);
    }

    @Override
    public List<UserResponse> findUsers() {
        return repository.findAll()
                .stream().map(UserResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse findById(UUID id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário", "id", id.toString()));
        return new UserResponse(user);
    }
}
