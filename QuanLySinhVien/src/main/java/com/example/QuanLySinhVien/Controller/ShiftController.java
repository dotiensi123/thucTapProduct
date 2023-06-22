package com.example.QuanLySinhVien.Controller;

import com.example.QuanLySinhVien.entity.Shift;
import com.example.QuanLySinhVien.service.Shift.ShiftService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
@RequestMapping("/shift")
public class ShiftController {
    private final ShiftService shiftService;
    @GetMapping("")
    public ResponseEntity<Object> findAllShift(){
        return new ResponseEntity<>(shiftService.findAllShift(),HttpStatusCode.valueOf(200));
    }
    @GetMapping("/find-by-id")
    public ResponseEntity<Object> findShiftById(@RequestParam(required = false) int id){
        Shift shift = shiftService.findShiftById(id);
        return shift == null ? ResponseEntity.ok("") : ResponseEntity.ok(shift);
    }
}
