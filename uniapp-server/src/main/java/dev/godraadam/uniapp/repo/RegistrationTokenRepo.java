package dev.godraadam.uniapp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.godraadam.uniapp.model.RegistrationToken;

@Repository
public interface RegistrationTokenRepo extends JpaRepository<RegistrationToken, Long> {
    Optional<RegistrationToken> findByToken(String token);
}
