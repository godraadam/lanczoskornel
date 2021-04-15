package dev.godraadam.uniapp.model;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class ApplicationUser extends BaseModel {
    
    private @Email String email;
    private String password;
    private @Size(min = 3, max = 20) String username;
 
}
