package dev.godraadam.uniapp.api.assembler;

import org.springframework.stereotype.Component;

import dev.godraadam.uniapp.api.dto.StudentRegisterDTO;
import dev.godraadam.uniapp.api.dto.UserDTO;
import dev.godraadam.uniapp.model.Student;

@Component
public class StudentAssembler {

    public Student createModel(StudentRegisterDTO dto) {
        Student student = new Student();
        student.setEmail(dto.getEmail());
        student.setUsername(dto.getUsername());
        student.setPassword(dto.getPassword());
        return student;
    }

    public UserDTO createDTO(Student student) {
        UserDTO dto = new UserDTO();
        dto.setEmail(student.getEmail());
        dto.setId(student.getId());
        dto.setUsername(student.getUsername());
        dto.setRole(student.getRole());
        return dto;
    }
    
}
