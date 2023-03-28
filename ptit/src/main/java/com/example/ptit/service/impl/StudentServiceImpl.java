package com.example.ptit.service.impl;

import com.example.ptit.dto.StudentDto;
import com.example.ptit.entity.Student;
import com.example.ptit.exception.ApplicationException;
import com.example.ptit.repository.StudentRepository;
import com.example.ptit.service.s3.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper mapper;
    @Override
    public List<StudentDto> findAllStudent() throws Exception {
        List<Student> students = studentRepository.findAll();
        if(students.isEmpty()){
            throw new ApplicationException(400,"no data");
        }
        else{
            List<StudentDto> studentDtos = new ArrayList<>();
            for (Student student: students) {
                StudentDto studentDto = mapper.map(student,StudentDto.class);
                studentDtos.add(studentDto);
            }
            return studentDtos;
        }
    }

    @Override
    public List<StudentDto> findStudentByAddressId(String addressId) {
        List<Student> students = studentRepository.findStudentByAddressId(addressId);
        return students.stream().map(student -> mapper.map(student, StudentDto.class)).toList();
    }

    @Override
    public void saveStudent(StudentDto studentDto) {
        Student student = mapper.map(studentDto,Student.class);
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }

    @Override
    public StudentDto findStudentByStudentCode(String studentCode) {
        Student student = studentRepository.findStudentByStudentCode(studentCode);
        StudentDto studentDto = mapper.map(student,StudentDto.class);
        return studentDto;
    }

    @Override
    public void updateStudent(StudentDto studentDto) {
        Student student = mapper.map(studentDto,Student.class);
        studentRepository.save(student);
    }

    @Override

    public List<StudentDto> findStudentByNameStartWith(String studentName) {
        List<Student> students = studentRepository.findStudentByNameStartWith(studentName);
        List<StudentDto> studentDtos = new ArrayList<>();
        for(Student student:students){
            StudentDto studentDto = mapper.map(student,StudentDto.class);
            studentDtos.add(studentDto);
        }
        return studentDtos;
    }


}
