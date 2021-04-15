package dev.godraadam.uniapp.api.assembler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.godraadam.uniapp.api.dto.GradeDTO;
import dev.godraadam.uniapp.model.Assignment;
import dev.godraadam.uniapp.model.Grade;
import dev.godraadam.uniapp.model.Student;
import dev.godraadam.uniapp.repo.AssignmentRepo;
import dev.godraadam.uniapp.repo.StudentRepo;
import dev.godraadam.uniapp.service.exception.ResourceNotFoundException;


@Service
public class GradeAssembler {
    
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private AssignmentRepo assignmentRepo;

    public Grade createModel(GradeDTO dto) {
        Student student = studentRepo.findById(dto.getStudentId()).orElseThrow(ResourceNotFoundException::new);
        Assignment assignment = assignmentRepo.findById(dto.getAssignmentId()).orElseThrow(ResourceNotFoundException::new);
        Grade grade = new Grade();
        grade.setAssignment(assignment);
        grade.setStudent(student);
        grade.setScore(dto.getScore());
        grade.setId(dto.getId());
        return grade;
    }
}
