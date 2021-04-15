package dev.godraadam.uniapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.godraadam.uniapp.model.Attendance;

public interface AttendanceRepo extends JpaRepository<Attendance, Long> {
    List<Attendance> findByLaboratoryId(Long id);
    List<Attendance> findByStudentId(Long id);
    List<Attendance> findByLaboratoryAndStatus(Long laboratoryId, Long studentId);
}
