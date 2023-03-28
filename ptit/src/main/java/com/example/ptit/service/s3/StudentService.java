package com.example.ptit.service.s3;

import com.example.ptit.dto.StudentDto;
import com.example.ptit.entity.Student;

import java.util.List;

public interface StudentService {
    List<StudentDto> findAllStudent() throws Exception;
    List<StudentDto> findStudentByAddressId(String addressId);
    void saveStudent(StudentDto studentDto);
    void deleteStudent(Student student);
    StudentDto findStudentByStudentCode(String studentCode);
    void updateStudent(StudentDto studentDto);
    List<StudentDto> findStudentByNameStartWith(String studentName);

}
