package dev.godraadam.uniapp.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.godraadam.uniapp.model.ApplicationUser;
import dev.godraadam.uniapp.model.Curriculum;
import dev.godraadam.uniapp.model.Teacher;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {
    List<Teacher> findByCurriculum(Curriculum curriculum);
    Optional<ApplicationUser> findByEmail(String email);
    Optional<ApplicationUser> findByUsername(String username);
}
