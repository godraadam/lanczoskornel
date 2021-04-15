package dev.godraadam.uniapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.godraadam.uniapp.model.Laboratory;

@Repository
public interface LaboratoryRepo extends JpaRepository<Laboratory, Long> {
    List<Laboratory> findByCurriculumId(Long id);
    List<Laboratory> findByTitle(String title);
}
