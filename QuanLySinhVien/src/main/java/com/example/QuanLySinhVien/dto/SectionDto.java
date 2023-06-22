package com.example.QuanLySinhVien.dto;

import com.example.QuanLySinhVien.entity.Registration;
import com.example.QuanLySinhVien.entity.Subject;
import lombok.*;

import java.util.List;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SectionDto {
    private String id;
    private String name;
    private String roomId;
    private int shiftId;
    private int num;
    private String subject_id;
}
