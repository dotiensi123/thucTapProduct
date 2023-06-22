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
public class Section {
    @Id
    private String id;
    private String name;
    private String roomId;
    private int shiftId;
    private int num;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @OneToMany(mappedBy = "section")
    private List<Registration> registrations;
}
