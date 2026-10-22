package com.ifpb.ifgram.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.ifpb.ifgram.Service.UserService;
import com.ifpb.ifgram.dto.UserRequest;
import com.ifpb.ifgram.dto.UserResponse;

    @RestController
    @RequestMapping("user")
    public class UserController {

        public final com.ifpb.ifgram.controller.UserService service;

        public UserController(com.ifpb.ifgram.controller.UserService service){
            this.service = service;
        }

        @GetMapping
        public List<UserResponse> getUsers(){
            List<UserResponse> listaUsuarios = service.buscarTodosUsuarios();
            return listaUsuarios;
        }

        @PostMapping
        public UserResponse postUser(UserRequest request) throws Exception {
            UserResponse userResponse = service.criar(request);
            return userResponse;
        }

        @PutMapping
        public UserResponse UpdateUser(UserRequest request) throws Exception {
            return service.atualizarUsuario(request);
        }

        @DeleteMapping
        public String deleteUser(UserRequest request) throws Exception {
            service.deletarUsuario(request);
            return "Usuário deletado com sucesso!";
    }

}
