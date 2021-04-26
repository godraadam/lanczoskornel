package dev.godraadam.uniapp.api.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.godraadam.uniapp.api.assembler.TeacherAssembler;
import dev.godraadam.uniapp.api.dto.TeacherDTO;
import dev.godraadam.uniapp.api.dto.UserDTO;
import dev.godraadam.uniapp.api.dto.UserRegisterDTO;
import dev.godraadam.uniapp.model.RegistrationToken;
import dev.godraadam.uniapp.model.Teacher;
import dev.godraadam.uniapp.service.TeacherService;
import dev.godraadam.uniapp.service.TokenService;

@RestController
public class TeacherController {
    
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TeacherAssembler teacherAssembler;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/api/teacher/register")
    public UserDTO register(@RequestBody UserRegisterDTO dto) {
        Teacher teacher =  teacherService.registerTeacher(modelMapper.map(dto, Teacher.class));
        return teacherAssembler.createDTO(teacher);
    }

    @GetMapping("/api/teacher/{id}")
    public TeacherDTO getTeacherById(@PathVariable Long id) {
        return teacherAssembler.createDTO(teacherService.getTeacherById(id));
    }

    @GetMapping("/api/teacher/token")
    public RegistrationToken generateToken() {
        return tokenService.generateToken();
    }
}
