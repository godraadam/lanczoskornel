package dev.godraadam.uniapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.godraadam.uniapp.model.Grade;

public interface GradeRepo extends JpaRepository<Grade, Long> {
    List<Grade> findByAssignmentId(Long id);
    List<Grade> findByStudentId(Long id);
}
