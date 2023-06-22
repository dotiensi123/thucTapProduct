package com.example.QuanLySinhVien.repo;

import com.example.QuanLySinhVien.entity.Shift;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ShiftRepo extends JpaRepository<Shift, Integer> {
    Shift findShiftById(int id);
}
