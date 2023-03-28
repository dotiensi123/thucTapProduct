package com.example.ptit.dto;

import com.example.ptit.entity.Course;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherDto {
    private String teacherCode;
    private String teacherName;
    private List<Course> courses;
}
