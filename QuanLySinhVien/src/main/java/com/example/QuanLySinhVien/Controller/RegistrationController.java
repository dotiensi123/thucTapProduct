package com.example.QuanLySinhVien.Controller;

import com.example.QuanLySinhVien.dto.RegistrationDto;
import com.example.QuanLySinhVien.entity.Registration;
import com.example.QuanLySinhVien.service.Registration.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping("/save")
    public ResponseEntity<Object> RegistrationOfStudent(@RequestBody RegistrationDto registrationDto){
        return new ResponseEntity<>(registrationService.saveRegistration(registrationDto), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/schedule-of-student-by-id")
    public ResponseEntity<Object> findRegistrationsByStudentId(@RequestParam(required = false) String studentId){
        return new ResponseEntity<>(registrationService.findRegistrationsByStudentId(studentId),HttpStatusCode.valueOf(200));
    }

    @GetMapping("/find-registrations-by-student-id-semester-id")
    public ResponseEntity<Object> findAllRegistrationByStudentIdAndSemesterId(@RequestParam(required = false) String studentId,
                                                                              @RequestParam(required = false) int semesterId){
        Object object = registrationService.findAllRegistrationByStudentIdAndSemesterId(studentId, semesterId);
        return object == null ? ResponseEntity.badRequest().body("not found") : ResponseEntity.ok(object);
    }

}
