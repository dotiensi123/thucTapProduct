package com.example.ptit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "registration")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Registration {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    Long id;

    @Column
    private String studentCode;
    @ManyToOne()
    @JoinColumn(name = "student_studentCode")
    private Student student;

    private String courseCode;
    @ManyToOne()
    @JoinColumn(name = "course_courseCode")
    public Course course;

    public double grade;

}
