package dev.godraadam.uniapp.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GradeDTO {
    private Long studentId;
    private Long assignmentId;
    private Float score;
    private Long id;
}
