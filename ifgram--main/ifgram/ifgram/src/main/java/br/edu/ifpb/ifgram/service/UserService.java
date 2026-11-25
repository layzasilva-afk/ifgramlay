package br.edu.ifpb.ifgram.service;

import br.edu.ifpb.ifgram.Repository.UserRepository;
import br.edu.ifpb.ifgram.Model.User;
import br.edu.ifpb.ifgram.dto.UserRequest;
import br.edu.ifpb.ifgram.dto.UserResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    // injeção de dependência pelo construtor
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public UserResponse criar(UserRequest request) {
        // regra de negócio: o e-mail não pode repetir

        User salvo = repository.save(new User(request.nome(), request.email()));
        return UserResponse.from(salvo);

    }
}















































