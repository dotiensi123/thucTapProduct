package com.example.QuanLySinhVien.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    private String id;
    private String password;
    private String name;
    private String birth;
    private int year;
    private String address;

    @OneToMany(mappedBy = "student")
    private List<Registration> registrations;
}

