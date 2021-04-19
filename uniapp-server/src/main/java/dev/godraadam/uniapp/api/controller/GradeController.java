package dev.godraadam.uniapp.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.godraadam.uniapp.api.assembler.GradeAssembler;
import dev.godraadam.uniapp.api.dto.GradeDTO;
import dev.godraadam.uniapp.model.Grade;
import dev.godraadam.uniapp.repo.GradeRepo;

@RestController
public class GradeController {

    @Autowired
    private GradeRepo gradeRepo;

    @Autowired
    private GradeAssembler gradeAssembler;

    @GetMapping("/api/grade/student/{id}")
    public List<GradeDTO> getGradesForStudent(@PathVariable Long id) {
        return gradeRepo.findByStudentId(id).stream().map(model -> gradeAssembler.createDTO(model))
                .collect(Collectors.toList());
    }

    @GetMapping("/api/grade/assignment/{id}")
    public List<GradeDTO> getGradesForAssignment(@PathVariable Long id) {
        return gradeRepo.findByAssignmentId(id).stream().map(model -> gradeAssembler.createDTO(model))
                .collect(Collectors.toList());
    }

    @PostMapping("/api/grade")
    public GradeDTO recordGrade(@RequestBody GradeDTO dto) {
        Grade grade = gradeRepo.save(gradeAssembler.createModel(dto));
        return gradeAssembler.createDTO(grade);
    }

    @PutMapping("/api/grade")
    public GradeDTO modifyGrade(@RequestBody GradeDTO dto) {
        return recordGrade(dto);
    }

    @DeleteMapping("/api/grade/delete/{id}")
    public void recordGrade(@PathVariable Long id) {
        gradeRepo.deleteById(id);
    }

}
