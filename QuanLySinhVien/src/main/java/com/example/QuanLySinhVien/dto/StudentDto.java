package com.example.QuanLySinhVien.dto;

import com.example.QuanLySinhVien.entity.Registration;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDto {
    private String id;
    private String name;
    private String birth;
    private int year;
    private String address;
}
