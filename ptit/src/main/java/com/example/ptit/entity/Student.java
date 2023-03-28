package com.example.ptit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    private String studentCode;

    @Column
    private String studentName;
    @Column
    private String addressId;
    @ManyToOne
    @JoinColumn(name = "address_addressId")
    private Address address;

    @OneToMany(mappedBy = "student")
    List<Registration> registrations;
}
