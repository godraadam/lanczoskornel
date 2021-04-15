package dev.godraadam.uniapp.repo;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.godraadam.uniapp.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    List<Student> findByGroup(String group);
    Optional<Student> findByEmail(String email);
    Optional<Student> findByUsername(String username);

}
