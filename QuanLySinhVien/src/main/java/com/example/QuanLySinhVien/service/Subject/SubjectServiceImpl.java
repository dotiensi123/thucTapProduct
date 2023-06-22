package com.example.QuanLySinhVien.service.Subject;

import com.example.QuanLySinhVien.dto.SectionDto;
import com.example.QuanLySinhVien.dto.SubjectDto;
import com.example.QuanLySinhVien.entity.Section;
import com.example.QuanLySinhVien.entity.Subject;
import com.example.QuanLySinhVien.repo.SubjectRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService{
    private final SubjectRepo subjectRepo;
    private final ModelMapper mapper;
    public List<SubjectDto> findAllSubject(){
        List<Subject> subjectList = subjectRepo.findAll();
        List<SubjectDto> subjectDtoList = subjectList.stream().map(subject -> mapper.map(subject,SubjectDto.class)).collect(Collectors.toList());
        return subjectDtoList;
    }

    @Override
    public SubjectDto findSubjectById(String id) {
        Subject subject =  subjectRepo.findSubjectsById(id);
        SubjectDto subjectDto = mapper.map(subject,SubjectDto.class);
        return subjectDto;
    }

    @Override
    public String addSubject(SubjectDto subjectDto) {
        Subject subject = mapper.map(subjectDto,Subject.class);
        subjectRepo.save(subject);
        return "ok";
    }



}
