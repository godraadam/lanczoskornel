package dev.godraadam.uniapp.api.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LaboratoryDTO {
    
    private Integer number;
    private String title;
    private LocalDateTime date;
    private String description;
    private Long curriculumId;

}
