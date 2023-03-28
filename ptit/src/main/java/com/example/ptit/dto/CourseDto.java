package com.example.ptit.dto;

import com.example.ptit.entity.Student;
import com.example.ptit.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourseDto {
    private String courseCode;
    private String courseName;
    private List<StudentDto> students;
    private List<Teacher> teachers;
}
