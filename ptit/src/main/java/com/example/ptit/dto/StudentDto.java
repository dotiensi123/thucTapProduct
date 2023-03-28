package com.example.ptit.dto;

import com.example.ptit.entity.Course;
import com.example.ptit.entity.Registration;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDto {
    private String studentCode;
    private String studentName;
    private String addressId;
    private AddressDto addressDto;
    private List<Course> courses;
}
