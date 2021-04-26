package dev.godraadam.uniapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.godraadam.uniapp.model.Teacher;
import dev.godraadam.uniapp.repo.TeacherRepo;
import dev.godraadam.uniapp.service.exception.EmailTakenException;
import dev.godraadam.uniapp.service.exception.UserNameTakenException;
import dev.godraadam.uniapp.service.exception.UserNotFoundException;

@Service
public class TeacherService {
    
    @Autowired
    private TeacherRepo teacherRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Teacher registerTeacher(Teacher teacherToRegister) throws UserNameTakenException, EmailTakenException {
        // Check if username is available
        teacherRepo.findByUsername(teacherToRegister.getUsername()).ifPresent(user -> {throw new UserNameTakenException();});
        
        // Check if email is available
        teacherRepo.findByEmail(teacherToRegister.getEmail()).ifPresent(user -> {throw new EmailTakenException();});
        
        // Encode password
        teacherToRegister.setPassword(passwordEncoder.encode(teacherToRegister.getPassword()));
        
        // Persist teacher entity
        return teacherRepo.save(teacherToRegister);
    }

    public Teacher getTeacherById(Long id) throws UserNotFoundException {
        return teacherRepo.findById(id).orElseThrow(UserNotFoundException::new);
    }
}
