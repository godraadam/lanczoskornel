package dev.godraadam.uniapp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.godraadam.uniapp.api.assembler.GradeAssembler;
import dev.godraadam.uniapp.api.dto.GradeDTO;
import dev.godraadam.uniapp.model.Grade;
import dev.godraadam.uniapp.repo.GradeRepo;

@RestController
public class GradeController {
    
    @Autowired
    private GradeRepo gradeRepo;

    @Autowired GradeAssembler gradeAssembler;

    @GetMapping("/api/grade/student/{id}")
    public List<Grade> getGradesForStudent(@PathVariable Long id) {
        return gradeRepo.findByStudentId(id);
    }

    @GetMapping("/api/grade/assignment/{id}")
    public List<Grade> getGradesForAssignment(@PathVariable Long id) {
        return gradeRepo.findByAssignmentId(id);
    }

    @PostMapping("/api/grade")
    public Grade recordGrade(@RequestParam GradeDTO grade) {
        return gradeRepo.save(gradeAssembler.createModel(grade));
    }

    @PutMapping("/api/grade")
    public Grade modifyGrade(@RequestParam GradeDTO grade) {
        return gradeRepo.save(gradeAssembler.createModel(grade));
    }

    @DeleteMapping("/api/grade/delete/{id}")
    public void recordGrade(@PathVariable Long id) {
        gradeRepo.deleteById(id);
    }

}
