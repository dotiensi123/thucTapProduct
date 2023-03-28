package com.example.ptit.repository;

import com.example.ptit.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,String> {
    @Query(value = "select * from teacher where teacher.teacher_code = ?1",nativeQuery = true)
    Teacher findTeacherByTeacherCode(String teacherCode);
}
