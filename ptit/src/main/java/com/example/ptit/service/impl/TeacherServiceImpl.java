package com.example.ptit.service.impl;

import com.example.ptit.dto.TeacherDto;
import com.example.ptit.entity.Teacher;
import com.example.ptit.repository.TeacherRepository;
import com.example.ptit.service.s3.TeacherService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final ModelMapper mapper;
    @Override
    public List<TeacherDto> findAllTeacher() throws Exception {
        List<Teacher> teachers = teacherRepository.findAll();
        List<TeacherDto> teacherDos = new ArrayList<>();
        if(teachers.isEmpty()){
            throw new Exception("ko co du lieu");
        }
        else{
             for(Teacher teacher:teachers){
                 TeacherDto teacherDto = mapper.map(teacher,TeacherDto.class);
                 teacherDos.add(teacherDto);
             }
        }
        return teacherDos;
    }

    @Override
    public TeacherDto findTeacherByTeacherCode(String teacherCode)  throws  Exception{
        Teacher teacher = teacherRepository.findTeacherByTeacherCode(teacherCode);
        if(teacher == null){
            throw  new Exception("ko co du lieu");
        }
        return mapper.map(teacher,TeacherDto.class);
    }

    @Override
    public void saveTeacher(Teacher teacher) throws Exception{
        Teacher teacher1 = teacherRepository.findTeacherByTeacherCode(teacher.getTeacherCode());
        if(teacher1 == null){
            teacherRepository.save(teacher);
        }
        else{
            throw new Exception("teacher da co");
        }
    }

    @Override
    public void deleteTeacher(Teacher teacher) throws Exception{
        Teacher teacher1 = teacherRepository.findTeacherByTeacherCode(teacher.getTeacherCode());
        if(teacher1 == null){
            throw new Exception("teacher ko co");
        }
        else{
            teacherRepository.delete(teacher);
        }
    }

    @Override
    public void updateTeacher(Teacher teacher) throws Exception{
        teacherRepository.save(teacher);
    }
}
