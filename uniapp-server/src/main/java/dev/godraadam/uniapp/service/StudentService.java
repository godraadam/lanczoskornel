package dev.godraadam.uniapp.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.godraadam.uniapp.model.RegistrationToken;
import dev.godraadam.uniapp.model.Student;
import dev.godraadam.uniapp.repo.RegistrationTokenRepo;
import dev.godraadam.uniapp.repo.StudentRepo;
import dev.godraadam.uniapp.service.exception.EmailTakenException;
import dev.godraadam.uniapp.service.exception.InvalidRegistrationTokenException;
import dev.godraadam.uniapp.service.exception.UserNameTakenException;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private RegistrationTokenRepo tokenRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Student registerStudent(Student studentToRegister, String token) throws UserNameTakenException, EmailTakenException, InvalidRegistrationTokenException {
        
        // Check if username is available
        studentRepo.findByUsername(studentToRegister.getUsername()).ifPresent(user -> {throw new UserNameTakenException();});
        
        // Check if email is available
        studentRepo.findByEmail(studentToRegister.getEmail()).ifPresent(user -> {throw new EmailTakenException();});
        
        // Check if registration token is valid
        RegistrationToken tokenFromRepo = tokenRepo.findByToken(token).orElseThrow(InvalidRegistrationTokenException::new);

        // Check if registration token is not expired
        if(tokenFromRepo.getExpiryDate().compareTo(LocalDateTime.now()) < 0) throw new InvalidRegistrationTokenException();
        
        // Encode password
        studentToRegister.setPassword(passwordEncoder.encode(studentToRegister.getPassword()));
        
        // Remove token from valid tokens
        tokenRepo.delete(tokenFromRepo);
        
        // Persist student entity
        return studentRepo.save(studentToRegister);
    }

}
