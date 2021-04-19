package dev.godraadam.uniapp.api.assembler;


import org.springframework.stereotype.Component;

import dev.godraadam.uniapp.api.dto.TeacherDTO;
import dev.godraadam.uniapp.model.Teacher;

@Component
public class TeacherAssembler {

    
    public Teacher createModel(TeacherDTO dto) {
        return null;
    }

    public TeacherDTO createDTO(Teacher model) {
        TeacherDTO dto = new TeacherDTO();
        dto.setEmail(model.getEmail());
        dto.setRole(model.getRole());
        dto.setId(model.getId());
        dto.setUsername(model.getUsername());
        if(model.getCurriculum() != null) dto.setCurriculumId(model.getCurriculum().getId());
        else dto.setCurriculumId(-1L);
        return dto;
    }
}
