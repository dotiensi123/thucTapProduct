package com.example.QuanLySinhVien.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Grade {
    @Id
    @GeneratedValue(generator = "grade_sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "grade_sequence", sequenceName = "grade_id_seq", allocationSize = 1)
    private Long id;
    private int grade1;
    private int grade2;
    private int grade3;
    private int grade4;
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "registration_id")
    private Registration registration;
}
