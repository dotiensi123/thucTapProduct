package com.example.QuanLySinhVien.dto;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDto {
    private String id;
    private String name;
    private int credits;
    private String id_pre;
    private Boolean status;
    public List<SectionDto> sectionDtos;
}
