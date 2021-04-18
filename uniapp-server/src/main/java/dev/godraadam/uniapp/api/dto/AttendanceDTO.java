package dev.godraadam.uniapp.api.dto;

import javax.validation.constraints.NotNull;

import dev.godraadam.uniapp.model.AttendanceStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttendanceDTO {

    @NotNull
    private Long studentId;
    @NotNull
    private Long laboratoryId;
    private Long id;
    @NotNull
    private AttendanceStatus status;
}
