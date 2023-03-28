package com.example.ptit.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Teacher {
    @Id
    private String teacherCode;
    @Column
    private String teacherName;

    @OneToMany(mappedBy = "teacher")
    List<Instruction> instructions;

}
