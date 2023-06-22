package com.example.QuanLySinhVien.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultOfStudent {
    private String studentId;
    private List<GradeDto> GradeDtos;
    private float tong;
    private String loai;
}
