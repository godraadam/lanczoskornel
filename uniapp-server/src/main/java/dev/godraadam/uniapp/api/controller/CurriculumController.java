package dev.godraadam.uniapp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.godraadam.uniapp.api.assembler.CurriculumAssembler;
import dev.godraadam.uniapp.api.dto.CurriculumDTO;
import dev.godraadam.uniapp.model.Curriculum;
import dev.godraadam.uniapp.repo.CurriculumRepo;

@RestController
public class CurriculumController {
    
    @Autowired
    private CurriculumRepo curriculumRepo;

    @Autowired 
    private CurriculumAssembler curriculumAssembler;

    @GetMapping("/api/curriculum/all")
    public List<Curriculum> getAllCurricula() {
        return curriculumRepo.findAll();
    }

    @PostMapping("/api/curriculum")
    public Curriculum addCurriculum(CurriculumDTO dto) {
        return curriculumRepo.save(curriculumAssembler.createModel(dto));
    }

    @PutMapping("/api/curriculum")
    public Curriculum editCurriculum(CurriculumDTO dto) {
        return curriculumRepo.save(curriculumAssembler.createModel(dto));
    }
   
    @DeleteMapping("/api/curriculum/delete/{id}")
    public void deleteCurriculum(Long id) {
        curriculumRepo.deleteById(id);
    }
}
