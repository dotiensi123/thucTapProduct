package com.example.QuanLySinhVien.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Registration {
    @Id
    @GeneratedValue(generator = "registration_sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "registration_sequence", sequenceName = "registration_id_seq", allocationSize = 1)
    private Long id;
    private int semesterId;
    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToMany(mappedBy = "registration")
    private List<Grade> grade;
}
