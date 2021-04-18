package dev.godraadam.uniapp.api.assembler;

import dev.godraadam.uniapp.api.dto.StudentRegisterDTO;
import dev.godraadam.uniapp.model.Student;

public class StudentAssembler {

    public Student createModel(StudentRegisterDTO dto) {
        Student student = new Student();
        student.setEmail(dto.getEmail());
        student.setUsername(dto.getUsername());
        student.setPassword(dto.getPassword());
        return student;
    }
    
}
