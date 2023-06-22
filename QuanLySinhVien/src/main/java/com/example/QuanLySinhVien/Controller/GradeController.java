package com.example.QuanLySinhVien.Controller;

import com.example.QuanLySinhVien.dto.GradeDto;
import com.example.QuanLySinhVien.service.Grade.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grade")
@RequiredArgsConstructor
public class GradeController {

    private final GradeService gradeService;
    @GetMapping("/{id}")
    public ResponseEntity<Object> findGradeByRegistrationId(@PathVariable Long id){
        return new ResponseEntity<>(gradeService.findGradeByRegistrationId(id), HttpStatusCode.valueOf(200));
    }

    @PostMapping("")
    public ResponseEntity<Object> saveGrade(@RequestBody GradeDto gradeDto) {
        String s = gradeService.saveGrade(gradeDto);
        return s.equals("registration not found") ? ResponseEntity.badRequest().body(s) : ResponseEntity.ok(s);
    }

    @GetMapping("/find-result-of-student")
    public ResponseEntity<Object> findResultOfStudent(@RequestParam(required = false) String studentId,
                                                      @RequestParam(required = false) int semesterId){
        return new ResponseEntity<>(gradeService.findResultOfStudent(studentId,semesterId),HttpStatusCode.valueOf(200));
    }

}
