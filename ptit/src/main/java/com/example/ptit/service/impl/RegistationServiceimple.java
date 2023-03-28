package com.example.ptit.service.impl;

import com.example.ptit.dto.StudentDto;
import com.example.ptit.entity.Course;
import com.example.ptit.entity.Registration;
import com.example.ptit.entity.Student;
import com.example.ptit.repository.CourseRepository;
import com.example.ptit.repository.RegistrationRepository;
import com.example.ptit.repository.StudentRepository;
import com.example.ptit.service.s3.CourseService;
import com.example.ptit.service.s3.RegistrationService;
import com.example.ptit.service.s3.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistationServiceimple implements RegistrationService {
     private final RegistrationRepository registrationRepository;
     private final StudentService studentService;
     private final CourseService courseService;

     // created a registration
    @Override
    public void saveRegistration(Registration registration) throws Exception {
        try{
            StudentDto studentDto = studentService.findStudentByStudentCode(registration.getStudentCode());
            Course course = courseService.findCourseByCourseCode(registration.getCourseCode());
            registrationRepository.save(registration);
        }catch(Exception e){
            throw new Exception("student or course not found");
        }

    }

    // delete registration
    @Override
    public void deleteRegistration(Registration registration) throws Exception {
        try{
            StudentDto studentDto = studentService.findStudentByStudentCode(registration.getStudentCode());
            Course course = courseService.findCourseByCourseCode(registration.getCourseCode());
            registrationRepository.delete(registration);
        }catch(Exception e){
            throw new Exception("student or course not found");
        }
    }

    @Override
    public List<String> findCoursesByStudentCode(String studentCode) throws  Exception{
        List<String> courses = registrationRepository.findCoursesByStudentCode(studentCode);
        if(courses.isEmpty()){
            throw new Exception("don't have any courses of student "+studentCode);
        }
        return courses;
    }

    @Override
    public List<String> findStudentByCourseCode(String courseCode) throws  Exception{
        List<String> students = registrationRepository.findStudentsByCourseCode(courseCode);
        if(students.isEmpty()){
            throw new Exception("don't have any student join course "+courseCode);
        }
        return students;
    }

    @Override
    public void updateRegistration(Registration registration) throws Exception {
         registrationRepository.save(registration);
    }

    @Override
    public Registration findRegistrationByStudentCodeAndCourseCode(String studentCode, String courseCode) throws Exception {
        Registration registration = registrationRepository.findRegistrationByStudentCodeAndCourseCode(studentCode,courseCode);
        if(registration==null){
            throw new Exception("don't have any registration");
        }
        else{
            return registration;
        }
    }
}
