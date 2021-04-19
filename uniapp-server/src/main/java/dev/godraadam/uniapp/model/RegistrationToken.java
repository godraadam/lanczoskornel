package dev.godraadam.uniapp.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "valid_tokens")
@Getter
@Setter
public class RegistrationToken extends BaseModel {
    
    private String token;
    private LocalDateTime expiryDate;
}
