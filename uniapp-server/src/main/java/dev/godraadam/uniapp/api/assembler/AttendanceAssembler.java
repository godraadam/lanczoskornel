package dev.godraadam.uniapp.api.assembler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.godraadam.uniapp.api.dto.AttendanceDTO;
import dev.godraadam.uniapp.model.Attendance;
import dev.godraadam.uniapp.model.Laboratory;
import dev.godraadam.uniapp.model.Student;
import dev.godraadam.uniapp.repo.LaboratoryRepo;
import dev.godraadam.uniapp.repo.StudentRepo;
import dev.godraadam.uniapp.service.exception.ResourceNotFoundException;

@Service
public class AttendanceAssembler {
    
    @Autowired
    private LaboratoryRepo labRepo;

    @Autowired
    private StudentRepo studentRepo;

    public Attendance createModel(AttendanceDTO dto) {
        Laboratory laboratory = labRepo.findById(dto.getLaboratoryId()).orElseThrow(ResourceNotFoundException::new);
        Student student = studentRepo.findById(dto.getStudentId()).orElseThrow(ResourceNotFoundException::new);
        Attendance attendance = new Attendance();
        attendance.setLaboratory(laboratory);
        attendance.setStudent(student);
        attendance.setStatus(dto.getStatus());
        attendance.setId(dto.getId());
        return attendance;
    }
}
