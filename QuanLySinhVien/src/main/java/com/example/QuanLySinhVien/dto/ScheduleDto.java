package com.example.QuanLySinhVien.dto;

import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ScheduleDto {
    private String sectionId;
    private int date;
    private LocalTime startTime;
    private LocalTime endTime;
}
