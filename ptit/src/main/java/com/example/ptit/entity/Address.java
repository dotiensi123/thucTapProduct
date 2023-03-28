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
public class Address {
    @Id
    private String addressId;
    @Column
    private String addressCity;
    @Column
    private String addressCountry;

    @OneToMany(mappedBy = "address")
    private List<Student> students;
}
