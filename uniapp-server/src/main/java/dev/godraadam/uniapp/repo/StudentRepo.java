package dev.godraadam.uniapp.repo;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.godraadam.uniapp.model.ApplicationUser;
import dev.godraadam.uniapp.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    List<Student> findByGroupName(String group);
    Optional<ApplicationUser> findByEmail(String email);
    Optional<ApplicationUser> findByUsername(String username);
}
