package com.example.QuanLySinhVien.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
public class Subject {
    @Id
    private String id;
    private String name;
    private int credits;
    private String id_pre;
    @OneToMany(mappedBy = "subject")
    private List<Section> sections;
}
