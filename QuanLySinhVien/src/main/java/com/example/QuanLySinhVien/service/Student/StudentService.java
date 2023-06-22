package com.example.QuanLySinhVien.service.Student;

import com.example.QuanLySinhVien.dto.StudentDto;
import com.example.QuanLySinhVien.entity.Student;

import java.util.List;

public interface StudentService {
    List<StudentDto> findAllStudent();
    String saveStudent(StudentDto studentDto);

}
