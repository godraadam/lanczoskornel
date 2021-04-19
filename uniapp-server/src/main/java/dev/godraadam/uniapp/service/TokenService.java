package dev.godraadam.uniapp.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.godraadam.uniapp.model.RegistrationToken;
import dev.godraadam.uniapp.repo.RegistrationTokenRepo;

@Service
public class TokenService {

    @Autowired
    private RegistrationTokenRepo tokenRepo;
    
    public RegistrationToken generateToken() {
        RegistrationToken token = new RegistrationToken();
        token.setToken(UUID.randomUUID().toString());
        token.setExpiryDate(LocalDateTime.now().plusWeeks(2L));
        return tokenRepo.save(token);
    }
}
