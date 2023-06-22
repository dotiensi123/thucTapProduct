package com.example.QuanLySinhVien.service.Shift;

import com.example.QuanLySinhVien.entity.Shift;

import java.util.List;

public interface ShiftService {
    Shift findShiftById(int id);
    List<Shift> findAllShift();
}
