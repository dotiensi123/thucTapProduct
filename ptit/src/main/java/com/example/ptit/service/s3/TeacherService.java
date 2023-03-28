package com.example.ptit.service.s3;

import com.example.ptit.dto.TeacherDto;
import com.example.ptit.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<TeacherDto> findAllTeacher() throws Exception;
    TeacherDto findTeacherByTeacherCode(String teacherCode) throws  Exception;
    void saveTeacher(Teacher teacher) throws Exception;
    void deleteTeacher(Teacher teacher) throws Exception;
    void updateTeacher(Teacher teacher) throws Exception;

}
