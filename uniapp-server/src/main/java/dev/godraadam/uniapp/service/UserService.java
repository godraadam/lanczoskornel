package dev.godraadam.uniapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.godraadam.uniapp.model.ApplicationUser;
import dev.godraadam.uniapp.model.Student;
import dev.godraadam.uniapp.repo.StudentRepo;
import dev.godraadam.uniapp.service.exception.EmailTakenException;
import dev.godraadam.uniapp.service.exception.IncorrectPasswordException;
import dev.godraadam.uniapp.service.exception.UserNameTakenException;
import dev.godraadam.uniapp.service.exception.UserNotFoundException;

@Service
public class UserService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ApplicationUser login(ApplicationUser userToLogin) throws IncorrectPasswordException, UserNotFoundException {
        ApplicationUser userFromRepo =  studentRepo.findByUsername(userToLogin.getUsername()).orElseThrow(UserNotFoundException::new);
        
        if (passwordEncoder.matches(userToLogin.getPassword(), userFromRepo.getPassword()) ) return userFromRepo;
        else throw new IncorrectPasswordException();

    }

    public ApplicationUser registerStudent(Student userToRegister) throws UserNameTakenException, EmailTakenException {
        studentRepo.findByUsername(userToRegister.getUsername()).ifPresent(u -> {throw new UserNameTakenException();});
        studentRepo.findByEmail(userToRegister.getEmail()).ifPresent(u -> {throw new EmailTakenException();});
        userToRegister.setPassword(passwordEncoder.encode(userToRegister.getPassword()));
        return studentRepo.save(userToRegister);
    }
}
