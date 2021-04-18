package dev.godraadam.uniapp.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.godraadam.uniapp.api.dto.LaboratoryDTO;
import dev.godraadam.uniapp.model.Curriculum;
import dev.godraadam.uniapp.model.Laboratory;
import dev.godraadam.uniapp.repo.CurriculumRepo;
import dev.godraadam.uniapp.service.exception.ResourceNotFoundException;

@Service
public class LaboratoryAssembler {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CurriculumRepo curriculumRepo;

    public Laboratory createModel(LaboratoryDTO dto) {
        Laboratory lab = modelMapper.map(dto, Laboratory.class);
        Curriculum curriculum = curriculumRepo.findById(dto.getCurriculumId())
                .orElseThrow(ResourceNotFoundException::new);
        lab.setCurriculum(curriculum);
        return lab;
    }

}
