package com.example.ptit.repository;

import com.example.ptit.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,String> {
    public Course findCourseByCourseCode(String courseCode);

}
