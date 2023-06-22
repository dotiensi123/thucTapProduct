package com.example.QuanLySinhVien.service.Grade;

import com.example.QuanLySinhVien.dto.GradeDto;
import com.example.QuanLySinhVien.dto.ResultOfStudent;
import com.example.QuanLySinhVien.dto.SemesterDto;
import com.example.QuanLySinhVien.entity.Grade;

import java.util.List;

public interface GradeService {
    GradeDto findGradeByRegistrationId(Long id);
    String saveGrade(GradeDto gradeDto);
    ResultOfStudent findResultOfStudent(String studentId, int semesterId);
    List<SemesterDto> findResultSemester(float diem);
}
