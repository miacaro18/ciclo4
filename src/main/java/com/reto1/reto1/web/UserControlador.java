/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto1.reto1.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reto1.reto1.model.User;
import com.reto1.reto1.service.UserServicio;

/**
 *
 * @author Miguel_Castro
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserControlador {
    
    /**
     * Autowired
     */
    @Autowired
    private UserServicio userServicio;

    /**
     * User getAll
     */
    @GetMapping("/all")
    public List<User> getAll() {
        return userServicio.getAll();
    }
    
    /**
     * Registrar new
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User registrar(@RequestBody User user) {
        return userServicio.save(user);
    }
    
    /**
     * Autenticar Combinacion
     */
    @GetMapping("/{email}/{password}")
    public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userServicio.autenticarUsuario(email, password);
    }
    
    /**
     * Exitencia Email
     */
    @GetMapping("/{email}")
    public boolean existeEmail(@PathVariable("email") String email) {
        return userServicio.existeEmail(email);
    }   
}
