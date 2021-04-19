package dev.godraadam.uniapp.api.assembler;

import org.springframework.stereotype.Component;

import dev.godraadam.uniapp.api.dto.UserLoginDTO;
import dev.godraadam.uniapp.model.ApplicationUser;

@Component
public class UserAssembler {

    public ApplicationUser createModel(UserLoginDTO dto) {
        ApplicationUser user = new ApplicationUser();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        return user;
    }
    
}
