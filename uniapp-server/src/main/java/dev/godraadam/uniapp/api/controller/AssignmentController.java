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
    public AssignmentDTO getAssignmentById(@PathVariable Long id) {
        Assignment assignment =  assignmentRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
        return assignmentAssembler.createDTO(assignment);
    }

    @GetMapping("/api/assignment/lab/{labId}")
    public List<AssignmentDTO> getAssignmentByLabId(@PathVariable Long labId) {
        return assignmentRepo.findByLaboratoryId(labId).stream()
                .map(assignment -> assignmentAssembler.createDTO(assignment)).collect(Collectors.toList());
    }

    @PostMapping("/api/assignment/create")
    public AssignmentDTO createAssignment(@RequestBody AssignmentDTO dto) {
        return editAssignment(dto);
    }

    @PutMapping("/api/assignment/edit")
    public AssignmentDTO editAssignment(@RequestBody AssignmentDTO dto) {
        Assignment assignment = assignmentRepo.save(assignmentAssembler.createModel(dto));
        return assignmentAssembler.createDTO(assignment);
    }

    @DeleteMapping("/api/assignment/delete/{id}")
    public void deleteAssignment(@PathVariable Long id) {
        assignmentRepo.deleteById(id);
    }
}
