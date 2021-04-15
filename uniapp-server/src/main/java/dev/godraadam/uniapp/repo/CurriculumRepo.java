package dev.godraadam.uniapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.godraadam.uniapp.model.Curriculum;

public interface CurriculumRepo extends JpaRepository<Curriculum, Long> {
    List<CurriculumRepo> findByTitle(String title);
}
