package dev.godraadam.uniapp.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterDTO {
    
    private @Size(min = 3, max = 20) String username;
    private String password;
    private @Email String email;
}
