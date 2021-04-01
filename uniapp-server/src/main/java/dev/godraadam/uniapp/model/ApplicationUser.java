package dev.godraadam.uniapp.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ApplicationUser extends BaseModel {
    
    private @Email String email;
    private String password;
    private @Size(min = 3, max = 20) String username;
    private @Embedded Role role;
}
