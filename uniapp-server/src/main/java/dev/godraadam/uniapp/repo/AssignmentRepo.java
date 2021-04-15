package dev.godraadam.uniapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.godraadam.uniapp.model.Assignment;

public interface AssignmentRepo extends JpaRepository<Assignment, Long> {
    List<Assignment> findByLaboratoryId(Long id);
}
