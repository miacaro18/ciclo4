package com.reto1.reto1.repository.crud;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.reto1.reto1.model.User;

public interface UserCrudRepositorio extends CrudRepository<User,Integer>{
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
    //Optional<User> findByName(String name);
}
