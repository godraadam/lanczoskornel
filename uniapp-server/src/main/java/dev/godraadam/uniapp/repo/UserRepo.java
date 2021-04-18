package dev.godraadam.uniapp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.godraadam.uniapp.model.ApplicationUser;

@Repository
public interface UserRepo extends JpaRepository<ApplicationUser , Long> {
    Optional<ApplicationUser> findByEmail(String email);
    Optional<ApplicationUser> findByUsername(String username);
}
