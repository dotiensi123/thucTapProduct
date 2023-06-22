package com.example.QuanLySinhVien.service.Registration;

import com.example.QuanLySinhVien.dto.RegistrationDto;
import com.example.QuanLySinhVien.dto.ScheduleDto;
import com.example.QuanLySinhVien.entity.Registration;

import java.util.List;
import java.util.Objects;

public interface RegistrationService {
    String saveRegistration(RegistrationDto registrationDto);
    List<ScheduleDto> findRegistrationsByStudentId(String studentId);
    List<RegistrationDto>  findAllRegistrationByStudentIdAndSemesterId(String studentId, int semesterId);
}
