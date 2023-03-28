package com.example.ptit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Instruction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String teacherCode;
    @ManyToOne
    @JoinColumn(name = "teacher_teacherCode")
    public Teacher teacher;

    private String courseCode;
    @ManyToOne()
    @JoinColumn(name= "course_courseCode")
    public Course course;

}
