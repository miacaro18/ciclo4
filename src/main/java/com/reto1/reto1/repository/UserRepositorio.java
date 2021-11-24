package com.reto1.reto1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto1.reto1.model.User;
import com.reto1.reto1.repository.crud.UserCrudRepositorio;

@Repository
public class UserRepositorio {
    @Autowired
    private UserCrudRepositorio userCrudRepositorio;

    public List<User>getAll(){
        return(List<User>)userCrudRepositorio.findAll();
    }

    public Optional<User>getUser(int id){
        return userCrudRepositorio.findById(id);
    }

    public User save(User user){
        return userCrudRepositorio.save(user);
    }

    public boolean existeEmail(String email) {
        Optional<User> usuario = userCrudRepositorio.findByEmail(email);
        return !usuario.isEmpty();
    }

    public Optional<User> autenticarUsuario(String email, String password) {
        return userCrudRepositorio.findByEmailAndPassword(email, password);
    }
}
