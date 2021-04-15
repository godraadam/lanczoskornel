package dev.godraadam.uniapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.godraadam.uniapp.model.Curriculum;
import dev.godraadam.uniapp.model.Enrollment;
import dev.godraadam.uniapp.model.Student;

public interface EnrollmentRepo extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByStudent(Student student);
    List<Enrollment> findByCurriculum(Curriculum curriculum);
}
