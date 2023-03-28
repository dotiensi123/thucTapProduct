package com.example.ptit.repository;

import com.example.ptit.entity.Instruction;
import org.apache.el.util.Validation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructRepository extends JpaRepository<Instruction,Long> {
    @Query(value = "select * from instruction where instruction.teacher_code = ?1",nativeQuery = true)
    List<String> findCoursesByTeacherCode(String teacherCode);

    @Query(value = "select * from instruction where instruction.course_code=?1",nativeQuery = true)
    List<String> findTeacherByCourseCode(String courseCode);

    @Query(value = "select * from instruction where instruction.teacher_code=?1 and instruction.course_code=?2",nativeQuery = true)
    Instruction findInstructionByTeacherCourseAndCourseCode(String teacherCode,String courseCode);
}
