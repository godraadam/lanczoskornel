package dev.godraadam.uniapp.api.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignmentDTO {
    
    private Long id;
    private Long labId;
    private LocalDateTime deadline;
    private String description;
}
