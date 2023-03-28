package com.example.ptit.controller;

import com.example.ptit.entity.Course;
import com.example.ptit.service.s3.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping()
    public ResponseEntity<Object> findAllCourse() {
        try {
            List<Course> courses = courseService.findAllCourse();
            return ResponseEntity.ok(courses);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{courseCode}")
    public ResponseEntity<Object> findCourseByCourseCode(@PathVariable("courseCode") String courseCode){
        try {
            Course course = courseService.findCourseByCourseCode(courseCode);
            return new ResponseEntity<>(course,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<Object> saveCourse(@RequestBody Course course) throws Exception {
         try{
             courseService.saveCourse(course);
             return new ResponseEntity<>("created",HttpStatus.CREATED);
         }catch(Exception e){
             return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
         }
    }
    @DeleteMapping("/{courseCode}")
    public ResponseEntity<Object> deleteCourseByCourseCode(@PathVariable("courseCode") String courseCode){
        try{
            courseService.deleteCourseByCourseCode(courseCode);
            return new ResponseEntity<>("delete ok",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/{courseCode}")
    public ResponseEntity<Object> updateCourseByCourseCode(@PathVariable("courseCode") String courseCode,
                                                      @RequestParam(required = false) String courseName) throws Exception {

        try{
            Course course = courseService.findCourseByCourseCode(courseCode);
            course.setCourseName(courseName);
            courseService.updateCourseByCourseCode(course);
            return new ResponseEntity<>("update ok", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
