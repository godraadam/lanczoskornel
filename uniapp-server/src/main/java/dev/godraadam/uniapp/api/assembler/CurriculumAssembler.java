package dev.godraadam.uniapp.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.godraadam.uniapp.api.dto.CurriculumDTO;
import dev.godraadam.uniapp.model.Curriculum;
import dev.godraadam.uniapp.model.Teacher;
import dev.godraadam.uniapp.repo.TeacherRepo;
import dev.godraadam.uniapp.service.exception.ResourceNotFoundException;

@Service
public class CurriculumAssembler {

    @Autowired
    private TeacherRepo teacherRepo;

    @Autowired
    private ModelMapper modelMapper;
    
    public Curriculum createModel(CurriculumDTO dto) {
        Curriculum curriculum = modelMapper.map(dto, Curriculum.class);
        Teacher teacher = teacherRepo.findById(dto.getTeacherId()).orElseThrow(ResourceNotFoundException::new);
        curriculum.setTeacher(teacher);
        return curriculum;
    }
}
