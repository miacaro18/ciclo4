package com.reto1.reto1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto1.reto1.model.User;
import com.reto1.reto1.repository.UserRepositorio;

@Service
public class UserServicio {
    @Autowired
    private UserRepositorio userRepositorio;

    public List<User> getAll() {
        return userRepositorio.getAll();
    }

    public Optional<User>getUser(int id){
        return userRepositorio.getUser(id);
    }

    public User save(User user) {
        if (user.getId() == null) {
            if (existeEmail(user.getEmail()) == false) {
                return userRepositorio.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean existeEmail(String email) {
        return userRepositorio.existeEmail(email);
    }

    public User autenticarUsuario(String email, String password) {
        Optional<User> usuario = userRepositorio.autenticarUsuario(email, password);

        if (usuario.isEmpty()) {
            return new User(email, password, "NO DEFINIDO");
            //return usuario.get();
        } else {
            return usuario.get();
        }
    }
}
