package com.example.ptit.service.impl;

import com.example.ptit.entity.Course;
import com.example.ptit.repository.CourseRepository;
import com.example.ptit.service.s3.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;


    @Override
    public List<Course> findAllCourse() throws Exception {
        List<Course> courses = courseRepository.findAll();
        if(courses.isEmpty()){
            throw new Exception("du lieu ko co");
        }
        return courses;
    }

    @Override
    public Course findCourseByCourseCode(String courseCode) throws Exception {
        Course course = courseRepository.findCourseByCourseCode(courseCode);
        if(course==null){
            throw new Exception("ko co du lieu");
        }
        return course;
    }

    @Override
    public void saveCourse(Course course) throws Exception {
        Course course1 = courseRepository.findCourseByCourseCode(course.getCourseCode());
        if(course1==null){
            courseRepository.save(course);
        }
        else{
            throw new Exception("course da co");
        }
    }

    @Override
    public void deleteCourseByCourseCode(String courseCode) throws Exception {
        Course course = courseRepository.findCourseByCourseCode(courseCode);
        if(course==null){
            throw new Exception("ko co du lieu de xoa");
        }
        else{
            courseRepository.delete(course);
        }
    }

    @Override
    public void updateCourseByCourseCode(Course course) throws Exception {
        courseRepository.save(course);
    }

}
