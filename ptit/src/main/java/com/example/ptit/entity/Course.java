package com.example.ptit.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    private String courseCode;
    @Column
    private String courseName;

    @OneToMany(mappedBy = "course")
    List<Registration> registrations;

    @OneToMany(mappedBy = "course")
    List<Instruction> instructions;
}
