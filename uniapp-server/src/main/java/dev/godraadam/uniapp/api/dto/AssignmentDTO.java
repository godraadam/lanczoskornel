package dev.godraadam.uniapp.api.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignmentDTO {
    
    @NotNull
    private Long id;
    @NotNull
    private Long labId;
    private LocalDateTime deadline;
    private String description;
}
