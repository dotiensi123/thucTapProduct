package com.example.ptit.repository;

import com.example.ptit.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration,Long> {
    @Query(value="select r.student_code from registration r where r.course_code = ?1", nativeQuery = true)
    List<String> findStudentsByCourseCode(String courseCode);
    @Query(value="select r.course_code from registration r where r.student_code = ?1", nativeQuery = true)
    List<String> findCoursesByStudentCode(String courseCode);

    @Query(value = "select * from registration r where r.student_code = ?1 and r.course_code = ?2",nativeQuery = true)
    Registration findRegistrationByStudentCodeAndCourseCode(String studentCode,String courseCode);
}
