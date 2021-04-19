package dev.godraadam.uniapp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.godraadam.uniapp.api.assembler.AttendanceAssembler;
import dev.godraadam.uniapp.api.dto.AttendanceDTO;
import dev.godraadam.uniapp.model.Attendance;
import dev.godraadam.uniapp.repo.AttendanceRepo;

@RestController
public class AttendanceController {

    @Autowired
    private AttendanceRepo attendanceRepo;

    @Autowired
    private AttendanceAssembler attendanceAssembler;
    
    @GetMapping("/api/attendance/lab/{id}")
    public List<Attendance> getAttendanceForLabId(@PathVariable Long id) {
        return attendanceRepo.findByLaboratoryId(id);
    }

    @GetMapping("/api/attendance/student/{id}")
    public List<Attendance> getAttendanceForStudentId(@PathVariable Long id) {
        return attendanceRepo.findByStudentId(id);
    }

    @PostMapping("api/attendance")
    public void recordAttendance(@RequestBody AttendanceDTO dto) {
        attendanceRepo.save(attendanceAssembler.createModel(dto));
    }

    @PutMapping("api/attendance")
    public void modifyAttendance(@RequestBody AttendanceDTO dto) {
        attendanceRepo.save(attendanceAssembler.createModel(dto));
    }

    @DeleteMapping("api/attendance/delete/{id}")
    public void removeAttendance(@PathVariable Long id) {
        attendanceRepo.deleteById(id);
    }
}
