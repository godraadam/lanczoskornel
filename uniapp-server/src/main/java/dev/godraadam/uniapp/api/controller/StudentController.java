package dev.godraadam.uniapp.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.godraadam.uniapp.api.assembler.StudentAssembler;
import dev.godraadam.uniapp.api.dto.StudentRegisterDTO;
import dev.godraadam.uniapp.api.dto.UserDTO;
import dev.godraadam.uniapp.model.Student;
import dev.godraadam.uniapp.service.StudentService;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentAssembler studentAssembler;


    
    @PostMapping("/api/student/register")
    public UserDTO registerStudent(@RequestBody StudentRegisterDTO dto) {
        Student student = studentAssembler.createModel(dto);
        Student registeredStudent = studentService.registerStudent(student, dto.getToken());
        return studentAssembler.createDTO(registeredStudent);
    }

}
