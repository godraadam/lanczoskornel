package dev.godraadam.uniapp.api.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.godraadam.uniapp.api.assembler.StudentAssembler;
import dev.godraadam.uniapp.api.dto.StudentRegisterDTO;
import dev.godraadam.uniapp.model.ApplicationUser;
import dev.godraadam.uniapp.model.Student;
import dev.godraadam.uniapp.service.StudentService;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentAssembler studentAssembler;

    
    
    @PostMapping("/api/student/register")
    public ApplicationUser registerStudent(@RequestParam StudentRegisterDTO dto) {
        UUID token = UUID.fromString(dto.getToken());
        Student student = studentAssembler.createModel(dto);
        return studentService.registerStudent(student, token);
    }

}
