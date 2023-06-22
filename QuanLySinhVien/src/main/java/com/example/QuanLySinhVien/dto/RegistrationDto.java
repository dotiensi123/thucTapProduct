package com.example.QuanLySinhVien.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {
    private int semesterId;
    private String sectionId;
    private String studentId;
}
