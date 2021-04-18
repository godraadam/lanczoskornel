package dev.godraadam.uniapp.api.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurriculumDTO {
    
    @NotBlank
    private String title;
    private Long teacherId;
    private Long id;
}
