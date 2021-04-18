package dev.godraadam.uniapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.godraadam.uniapp.model.ApplicationUser;
import dev.godraadam.uniapp.repo.UserRepo;
import dev.godraadam.uniapp.service.exception.IncorrectPasswordException;
import dev.godraadam.uniapp.service.exception.UserNotFoundException;

@Service
public class UserService {
    
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ApplicationUser login(ApplicationUser userToLogin) throws UserNotFoundException, IncorrectPasswordException {
        ApplicationUser userFromRepo = userRepo.findByUsername(userToLogin.getUsername()).orElseThrow(UserNotFoundException::new);
        if (!passwordEncoder.matches(userToLogin.getPassword(), userFromRepo.getPassword())) {
            throw new IncorrectPasswordException();
        }
        return userFromRepo;
    }

    public ApplicationUser findById(Long id) throws UserNotFoundException {
        return userRepo.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public ApplicationUser findByUsername(String username) throws UserNotFoundException {
        return userRepo.findByUsername(username).orElseThrow(UserNotFoundException::new);
    }

    public ApplicationUser findByEmail(String email) throws UserNotFoundException {
        return userRepo.findByEmail(email).orElseThrow(UserNotFoundException::new);
    }

}
