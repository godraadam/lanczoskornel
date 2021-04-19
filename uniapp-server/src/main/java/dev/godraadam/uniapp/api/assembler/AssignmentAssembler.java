package dev.godraadam.uniapp.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.godraadam.uniapp.api.dto.AssignmentDTO;
import dev.godraadam.uniapp.model.Assignment;
import dev.godraadam.uniapp.model.Laboratory;
import dev.godraadam.uniapp.repo.LaboratoryRepo;
import dev.godraadam.uniapp.service.exception.ResourceNotFoundException;

@Service
public class AssignmentAssembler {

    @Autowired
    private LaboratoryRepo labRepo;

    @Autowired
    private ModelMapper modelMapper;

    public Assignment createModel(AssignmentDTO dto) {
        Laboratory laboratory = labRepo.findById(dto.getLabId()).orElseThrow(ResourceNotFoundException::new);
        Assignment assignment = modelMapper.map(dto, Assignment.class);
        assignment.setLaboratory(laboratory);
        return assignment;
    }

    public AssignmentDTO createDTO(Assignment model) {
        AssignmentDTO dto = modelMapper.map(model, AssignmentDTO.class);
        dto.setLabId(model.getLaboratory().getId());
        return dto;
    }
    
}
