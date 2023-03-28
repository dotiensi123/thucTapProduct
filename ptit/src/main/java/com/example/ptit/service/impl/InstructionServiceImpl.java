package com.example.ptit.service.impl;

import com.example.ptit.dto.TeacherDto;
import com.example.ptit.entity.Course;
import com.example.ptit.entity.Instruction;
import com.example.ptit.entity.Teacher;
import com.example.ptit.repository.InstructRepository;
import com.example.ptit.service.s3.CourseService;
import com.example.ptit.service.s3.InstructionService;
import com.example.ptit.service.s3.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructionServiceImpl implements InstructionService {

    private final CourseService courseService;
    private final TeacherService teacherService;
    private final InstructRepository instructRepository;

    @Override
    public void saveInstruction(Instruction instruction) throws Exception{
            Course course = courseService.findCourseByCourseCode(instruction.getCourseCode());
            TeacherDto teacherDto = teacherService.findTeacherByTeacherCode(instruction.getTeacherCode());
        if(course== null || teacherDto==null ){
            throw new Exception("course or teacher not found");
        }
        instructRepository.save(instruction);
    }

    @Override
    public void deleteInstruction(Instruction instruction) throws Exception {
        try{
            Course course = courseService.findCourseByCourseCode(instruction.getCourseCode());
            TeacherDto teacherDto = teacherService.findTeacherByTeacherCode(instruction.getTeacherCode());
            instructRepository.delete(instruction);
        }catch(Exception e){
            throw new Exception("course or teacher not found");
        }
    }

    @Override
    public List<String> findTeacherByCourseCode(String courseCode) throws Exception {
        List<String> teachers = instructRepository.findTeacherByCourseCode(courseCode);
        if(teachers.isEmpty()){
            throw new Exception("don't have any courses of teacher "+ courseCode);
        }
        return teachers;
    }

    @Override
    public List<String> findCourseByTeacherCode(String teacherCode) throws Exception {
        List<String> courses = instructRepository.findCoursesByTeacherCode(teacherCode);
        if(courses.isEmpty()){
            throw new Exception("don't have Teacher of this courses "+teacherCode);
        }
        return courses;
    }

    @Override
    public void updateInstruction(Instruction instruction) throws Exception {
        instructRepository.save(instruction);
    }

    @Override
    public Instruction findInstructionByTeacherCodeAndCourseCode(String teacherCode, String courseCode) throws Exception {
        Instruction instruction = instructRepository.findInstructionByTeacherCourseAndCourseCode(teacherCode,courseCode);
        if(instruction==null){
            throw new Exception("ko ton tai giao vien"+teacherCode+" day mon nay "+courseCode);
        }
        return instruction;
    }
}
