package dev.godraadam.uniapp.api.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LaboratoryDTO {
    
    private Integer number;
    private String title;
    private LocalDateTime date;
    private String description;
    @NotNull
    private Long curriculumId;

}
