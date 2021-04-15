package dev.godraadam.uniapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.godraadam.uniapp.model.Curriculum;
import dev.godraadam.uniapp.model.Teacher;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {
    List<Teacher> findByCurriculum(Curriculum curriculum);
}
