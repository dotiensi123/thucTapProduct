package com.example.QuanLySinhVien.service.Shift;

import com.example.QuanLySinhVien.entity.Shift;
import com.example.QuanLySinhVien.repo.ShiftRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ShiftServiceImpl implements ShiftService{
    private final ShiftRepo shiftRepo;
    @Override
    public Shift findShiftById(int id) {
        return shiftRepo.findShiftById(id);
    }

    @Override
    public List<Shift> findAllShift() {
        return shiftRepo.findAll();
    }
}
