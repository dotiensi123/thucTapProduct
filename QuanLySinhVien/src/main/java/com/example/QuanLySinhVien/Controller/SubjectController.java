package com.example.QuanLySinhVien.Controller;

import com.example.QuanLySinhVien.dto.SubjectDto;
import com.example.QuanLySinhVien.entity.Subject;
import com.example.QuanLySinhVien.service.Subject.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/subject")
public class SubjectController {
    private final SubjectService subjectService;
    @GetMapping("")
    public ResponseEntity<Object> findAllSubject(){
        return new ResponseEntity<>(subjectService.findAllSubject(), HttpStatusCode.valueOf(200));
    }
    @GetMapping("/find-subject-by-id")
    public ResponseEntity<Object> findSubjectById(@RequestParam String id){
        return new ResponseEntity<>(subjectService.findSubjectById(id),HttpStatusCode.valueOf(200));
    }
    @PostMapping("")
    public ResponseEntity<Object> saveSubject(@RequestBody SubjectDto subjectDto){
        return new ResponseEntity<>(subjectService.addSubject(subjectDto),HttpStatusCode.valueOf(200));
    }
}
