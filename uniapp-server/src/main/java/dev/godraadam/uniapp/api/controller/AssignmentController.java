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

import dev.godraadam.uniapp.api.assembler.AssignmentAssembler;
import dev.godraadam.uniapp.api.dto.AssignmentDTO;
import dev.godraadam.uniapp.model.Assignment;
import dev.godraadam.uniapp.repo.AssignmentRepo;
import dev.godraadam.uniapp.service.exception.ResourceNotFoundException;

@RestController
public class AssignmentController {
    
    @Autowired
    private AssignmentRepo assignmentRepo;

    @Autowired
    private AssignmentAssembler assignmentAssembler;

    @GetMapping("/api/assignment/{id}")
    public Assignment getAssignmentById(@PathVariable Long id) {
        return assignmentRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @GetMapping("/api/assignment/lab/{labId}")
    public List<Assignment> getAssignmentByLabId(@PathVariable Long labId) {
        return assignmentRepo.findByLaboratoryId(labId);
    }

    @PostMapping("/api/assignment") 
    public void createAssignment(@RequestParam AssignmentDTO assignment) {
        assignmentRepo.save(assignmentAssembler.createModel(assignment));
    }

    @PutMapping("/api/assignment") 
    public void editAssignment(@RequestParam AssignmentDTO assignment) {
        assignmentRepo.save(assignmentAssembler.createModel(assignment));
    }

    @DeleteMapping("/api/assignment/delete/{id}") 
    public void deleteAssignment(@PathVariable Long id) {
        assignmentRepo.deleteById(id);
    }
}
