package dev.godraadam.uniapp.api.dto;

import dev.godraadam.uniapp.model.AttendanceStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttendanceDTO {
    private Long studentId;
    private Long laboratoryId;
    private Long id;
    private AttendanceStatus status;
}
