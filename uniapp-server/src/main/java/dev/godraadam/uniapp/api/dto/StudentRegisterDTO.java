package dev.godraadam.uniapp.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class StudentRegisterDTO extends UserRegisterDTO {
    
    private String token;
}
