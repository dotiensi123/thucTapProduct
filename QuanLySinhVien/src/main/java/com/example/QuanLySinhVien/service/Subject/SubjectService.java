package com.example.QuanLySinhVien.service.Subject;

import com.example.QuanLySinhVien.dto.SectionDto;
import com.example.QuanLySinhVien.dto.SubjectDto;
import com.example.QuanLySinhVien.entity.Subject;

import java.util.List;

public interface SubjectService {
    List<SubjectDto> findAllSubject();
    SubjectDto findSubjectById(String id);
    String addSubject(SubjectDto subjectDto);
}
