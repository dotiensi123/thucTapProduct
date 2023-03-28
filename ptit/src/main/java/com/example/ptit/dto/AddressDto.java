package com.example.ptit.dto;

import com.example.ptit.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private String addressId;
    private String addressCity;
    private String addressCountry;
    private List<StudentDto> studentDtos;
}
