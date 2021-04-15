package dev.godraadam.uniapp.api.assembler;

import org.springframework.beans.factory.annotation.Autowired;

import dev.godraadam.uniapp.api.dto.AssignmentDTO;
import dev.godraadam.uniapp.model.Assignment;
import dev.godraadam.uniapp.model.Laboratory;
import dev.godraadam.uniapp.repo.LaboratoryRepo;
import dev.godraadam.uniapp.service.exception.ResourceNotFoundException;

public class AssignmentAssembler {

    @Autowired
    private LaboratoryRepo labRepo;

    public Assignment createModel(AssignmentDTO dto) {
        Laboratory laboratory = labRepo.findById(dto.getLabId()).orElseThrow(ResourceNotFoundException::new);
        Assignment assignment = new Assignment();
        assignment.setDeadline(dto.getDeadline());
        assignment.setDescription(dto.getDescription());
        assignment.setLaboratory(laboratory);
        assignment.setId(dto.getId());
        return assignment;
    }
    
}
