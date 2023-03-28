package com.example.ptit.service.s3;

import com.example.ptit.entity.Course;
import com.example.ptit.entity.Instruction;

import java.util.List;

public interface InstructionService {
    void saveInstruction(Instruction instruction) throws Exception;
    void deleteInstruction(Instruction instruction) throws Exception;
    List<String> findTeacherByCourseCode(String courseCode) throws Exception;
    List<String> findCourseByTeacherCode(String teacherCode) throws Exception;

    void updateInstruction(Instruction instruction) throws Exception;

    public Instruction findInstructionByTeacherCodeAndCourseCode(String studentCode,String courseCode) throws Exception;
}
