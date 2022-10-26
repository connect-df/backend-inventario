package com.backend.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.spring.model.User;
import com.backend.spring.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	 @Autowired
	    private UserService userService;

	   
	    @GetMapping
	    public List<User> obterTodos() {
	        return userService.obterTodos();
	    }

	    
	    @GetMapping("/{id}")
	    public Optional<User> obterporId(@PathVariable Integer id) {
	        return userService.obterPorId(id);
	    }

	    
	    @PostMapping
	    public User adicionar(@RequestBody User user) {
	        return userService.adicionar(user);

	    }

	   
	    @DeleteMapping("/{id}")
	    public String deletar(@PathVariable Integer id) {
	        userService.deletar(id);
	        return "Usuario com id: " + id + " Deletado com sucesso!";
	    }

	    
	    @PutMapping("/{id}")
	    public User atualizar(@PathVariable Integer id,@RequestBody User user) {
	        return userService.atualizar(id, user);

	    }
	
}