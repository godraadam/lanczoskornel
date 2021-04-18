package dev.godraadam.uniapp.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GradeDTO {

    @NotNull
    private Long studentId;
    @NotNull
    private Long assignmentId;
    @Positive
    private Float score;
    private Long id;
}
