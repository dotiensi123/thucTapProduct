package com.example.QuanLySinhVien.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GradeDto {
    private int grade1;
    private int grade2;
    private int grade3;
    private int grade4;
    private float tong;
    private Boolean status;
    private Long registration_id;

}
