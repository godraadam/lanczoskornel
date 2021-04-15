package dev.godraadam.uniapp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.godraadam.uniapp.model.Curriculum;
import dev.godraadam.uniapp.repo.CurriculumRepo;

@RestController
public class CurriculumController {
    
    @Autowired
    private CurriculumRepo curriculumRepo;

    @GetMapping
    public List<Curriculum> getAllCurricula() {
        return curriculumRepo.findAll();
    }
}
