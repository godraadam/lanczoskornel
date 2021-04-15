package dev.godraadam.uniapp.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import dev.godraadam.uniapp.model.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    
    private Long id;
    private @Size(min = 3, max = 20) String username;
    private @Email String email;
    private Role role;
}
