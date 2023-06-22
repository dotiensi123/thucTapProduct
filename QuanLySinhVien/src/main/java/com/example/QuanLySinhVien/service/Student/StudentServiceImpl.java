package com.example.QuanLySinhVien.service.Student;

import com.example.QuanLySinhVien.dto.StudentDto;
import com.example.QuanLySinhVien.entity.Student;
import com.example.QuanLySinhVien.repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    private final StudentRepo studentRepo;
    private final ModelMapper mapper;
    @Override
    public List<StudentDto> findAllStudent() {
        List<Student> studentList = studentRepo.findAll();
        List<StudentDto> studentDtoList = studentList.stream().map(student -> mapper.map(student,StudentDto.class)).collect(Collectors.toList());
        return studentDtoList;
    }

    @Override
    public String saveStudent(StudentDto studentDto) {
        Student student1 = studentRepo.findStudentById(studentDto.getId());
        if(student1 == null){
            Student student = mapper.map(studentDto,Student.class);
            studentRepo.save(student);
            return "save ok";
        }
        return "not ok";
    }
}
