package com.example.ptit.controller;

import com.example.ptit.dto.TeacherDto;
import com.example.ptit.entity.Teacher;
import com.example.ptit.service.s3.TeacherService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    private final ModelMapper mapper;

    @GetMapping()
    public ResponseEntity<?> findAllTeacher() throws Exception {
        try{
            List<TeacherDto> teacherDtoList = teacherService.findAllTeacher();
            return new ResponseEntity<>(teacherDtoList,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{teacherCode}")
    public ResponseEntity<?> findTeacherByTeacherCode(@PathVariable("teacherCode") String teacherCode){
        try{
            TeacherDto teacherDto = teacherService.findTeacherByTeacherCode(teacherCode);
            return new ResponseEntity<>(teacherDto,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping()
    public ResponseEntity<?> saveTeacher(@RequestBody Teacher teacher){
        try{
            teacherService.saveTeacher(teacher);
            return new ResponseEntity<>("save ok",HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{teacherCode}")
    public ResponseEntity<?> deleteTeacherByTeacher(@PathVariable("teacherCode") String teacherCode){
        try{
            TeacherDto teacherDto = teacherService.findTeacherByTeacherCode(teacherCode);
            Teacher teacher = mapper.map(teacherDto,Teacher.class);
            teacherService.deleteTeacher(teacher);
            return new ResponseEntity<>("delete ok",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{teacherCode}")
    public ResponseEntity<?> updateTeacherByTeacherCode(@PathVariable("teacherCode") String teacherCode,
                                                        @RequestParam(required = false) String teacherName){
        try{
            TeacherDto teacherDto = teacherService.findTeacherByTeacherCode(teacherCode);
            Teacher teacher = mapper.map(teacherDto,Teacher.class);
            teacher.setTeacherName(teacherName);
            teacherService.updateTeacher(teacher);
            return new ResponseEntity<>("update ok",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
