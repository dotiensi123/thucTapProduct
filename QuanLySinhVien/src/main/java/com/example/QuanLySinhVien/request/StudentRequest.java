package com.example.QuanLySinhVien.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentRequest {
    private String id;
    private String name;
    private String address;
    private int year;
    private double grade;
}
