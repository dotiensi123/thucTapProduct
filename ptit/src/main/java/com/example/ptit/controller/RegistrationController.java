package com.example.ptit.controller;

import com.example.ptit.dto.CourseDto;
import com.example.ptit.dto.StudentDto;
import com.example.ptit.entity.Course;
import com.example.ptit.entity.Registration;

import com.example.ptit.service.s3.CourseService;
import com.example.ptit.service.s3.RegistrationService;
import com.example.ptit.service.s3.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;
    private final CourseService courseService;
    private final StudentService studentService;
    // created a registration about student and course

    /**
     * @param studentCode mã sinh viên
     * @param courseCode mã khóa học
     * @return sinh viên này có đăng kí khóa học nay không
     */
    @GetMapping("/{studentCode}/{courseCode}")
    public ResponseEntity<Object> findRegistrationByStudentCodeAndCourseCode(@PathVariable("studentCode") String studentCode,
                                                                       @PathVariable("courseCode") String courseCode){
        try{
            Registration registration = registrationService.findRegistrationByStudentCodeAndCourseCode(studentCode,courseCode);
            return new ResponseEntity<>(registration,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * @param registration
     * @return lưu sự đăng kí
     */
    @PostMapping()
    public ResponseEntity<Object> saveRegistration(@RequestBody Registration registration){
        try{
            registrationService.saveRegistration(registration);
            return new ResponseEntity<>("save ok", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * @param registration là sự đăng kí
     * @return xóa đi sự đăng kí
     */
    @DeleteMapping()
    public ResponseEntity<Object> deleteRegistraion(@RequestBody Registration registration){
        try{
            registrationService.deleteRegistration(registration);
            return new ResponseEntity<>("delete student "+registration.getStudentCode()
                                        +" courseCode "+registration.getCourseCode(),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * @param studentCode mã sinh viên
     * @param courseCode  mã khóa học
     * @param gradeValue  Diem so
     * @return value
     */
    @PutMapping("/{studentCode}/{courseCode}")
    public ResponseEntity<Object> updateRegistration(@PathVariable("studentCode") String studentCode,
                                                @PathVariable("courseCode") String courseCode,
                                                @RequestParam(required = false) double gradeValue){
        try{
            Registration registration = registrationService.findRegistrationByStudentCodeAndCourseCode(studentCode,courseCode);
            registration.setGrade(gradeValue);
            registrationService.updateRegistration(registration);
            return new ResponseEntity<>("update ok",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * @param studentCode mã sinh viên
     * @return trả về các course của student
     */
    @GetMapping("/{studentCode}/courses")
    public ResponseEntity<Object> findCoursesByStudentCode(@PathVariable("studentCode") String studentCode){
        try{
            StudentDto studentDto = studentService.findStudentByStudentCode(studentCode);
            List<String> courses = registrationService.findCoursesByStudentCode(studentCode);
            List<Course> course1 = new ArrayList<>();
            for (String courseCode: courses){
                Course course = courseService.findCourseByCourseCode(courseCode);
                course1.add(course);
            }
            studentDto.setCourses(course1);
            return new ResponseEntity<>(studentDto,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * @param courseCode mã course
     * @return các những student với course
     */
    @GetMapping("/{courseCode}/students")
    public ResponseEntity<Object> findStudentsByCourseCode(@PathVariable("courseCode") String courseCode){
        try{
            List<String> students = registrationService.findStudentByCourseCode(courseCode);
            List<StudentDto> studentDtos = new ArrayList<>();
            for (String studentCode: students){
                StudentDto studentDto = studentService.findStudentByStudentCode(studentCode);
                studentDtos.add(studentDto);
            }
            CourseDto courseDto = new CourseDto();
            courseDto.setStudents(studentDtos);
            return new ResponseEntity<>(courseDto,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
