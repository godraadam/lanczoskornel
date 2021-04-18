package dev.godraadam.uniapp.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
public class ApplicationUser extends BaseModel {
    
    private @Email String email;
    private String password;
    private @Size(min = 3, max = 20) String username;
    private Role role;
}
