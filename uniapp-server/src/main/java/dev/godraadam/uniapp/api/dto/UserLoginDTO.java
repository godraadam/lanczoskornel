package dev.godraadam.uniapp.api.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginDTO {

    private @NotBlank String username;
    private @NotBlank String password;
}
