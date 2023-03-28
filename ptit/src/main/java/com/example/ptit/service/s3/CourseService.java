package com.example.ptit.service.s3;

import com.example.ptit.entity.Course;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CourseService {
    List<Course> findAllCourse() throws Exception;
    Course findCourseByCourseCode(String courseCode) throws Exception;
    void saveCourse(Course course) throws Exception;
    void deleteCourseByCourseCode(String courseCode) throws Exception;

    void updateCourseByCourseCode(Course course) throws Exception;
}
