package com.example.QuanLySinhVien.Controller;

import com.example.QuanLySinhVien.dto.StudentDto;
import com.example.QuanLySinhVien.entity.Student;
import com.example.QuanLySinhVien.service.Student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("")
    public ResponseEntity<Object> findAllStudent(){
        return new ResponseEntity<>(studentService.findAllStudent(), HttpStatusCode.valueOf(200));
    }
    @PostMapping("")
    public ResponseEntity<Object> saveStudent(@RequestBody StudentDto studentDto){
        return new ResponseEntity<>(studentService.saveStudent(studentDto),HttpStatusCode.valueOf(200));
    }
}
