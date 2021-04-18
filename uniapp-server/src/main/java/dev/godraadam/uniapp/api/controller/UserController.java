package dev.godraadam.uniapp.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.godraadam.uniapp.api.assembler.UserAssembler;
import dev.godraadam.uniapp.api.dto.UserLoginDTO;
import dev.godraadam.uniapp.model.ApplicationUser;
import dev.godraadam.uniapp.service.UserService;

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private UserAssembler userAssembler;

    @GetMapping("/api/user/{id}")
    public ApplicationUser getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/api/user/username/{username}")
    public ApplicationUser getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("/api/user/email/{email}")
    public ApplicationUser getUserByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @PostMapping("/api/login")
    public ApplicationUser login(@RequestParam UserLoginDTO dto) {
        return userService.login(userAssembler.createModel(dto));
    }

}
