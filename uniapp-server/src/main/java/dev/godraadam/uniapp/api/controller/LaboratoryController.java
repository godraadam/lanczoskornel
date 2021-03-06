package dev.godraadam.uniapp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.godraadam.uniapp.api.assembler.LaboratoryAssembler;
import dev.godraadam.uniapp.api.dto.LaboratoryDTO;
import dev.godraadam.uniapp.model.Laboratory;
import dev.godraadam.uniapp.repo.LaboratoryRepo;

@RestController
public class LaboratoryController {
    
    @Autowired
    LaboratoryRepo labRepo;

    @Autowired 
    private LaboratoryAssembler laboratoryAssembler;

    @GetMapping("/api/lab/curriculum/{id}")
    public List<Laboratory> getAllLabsForCurriculum(Long id) {
        return labRepo.findByCurriculumId(id);
    }

    @PostMapping("/api/lab/create")
    public LaboratoryDTO createLaboratory(@RequestBody LaboratoryDTO dto) {
        Laboratory laboratory = labRepo.save(laboratoryAssembler.createModel(dto));
        return laboratoryAssembler.createDTO(laboratory);
    }

    @PutMapping("/api/lab/edit")
    public Laboratory modifyLaboratory(@RequestBody LaboratoryDTO dto) {
        return labRepo.save(laboratoryAssembler.createModel(dto));
    }

    @DeleteMapping("/api/lab/delete/{id}")
    public void deleteLaboratory(@PathVariable Long id) {
         labRepo.deleteById(id);
    }

}
