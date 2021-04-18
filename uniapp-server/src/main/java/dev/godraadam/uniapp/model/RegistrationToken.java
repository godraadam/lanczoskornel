package dev.godraadam.uniapp.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "valid_tokens")
@Getter
@Setter
public class RegistrationToken extends BaseModel {
    
    private UUID token;
    private LocalDateTime expiryDate;
}
