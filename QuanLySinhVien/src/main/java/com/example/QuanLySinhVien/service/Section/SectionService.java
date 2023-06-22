package com.example.QuanLySinhVien.service.Section;

import com.example.QuanLySinhVien.dto.SectionDto;
import com.example.QuanLySinhVien.entity.Section;

import java.util.List;

public interface SectionService {
    List<SectionDto> findAllSection();
    Section findSectionById(String id);
    Section findSectionByShiftIdAndRoomId(int shiftId, String roomId);
    String addSection(SectionDto sectionDto);
    List<SectionDto> findAllBySubjectId(String subjectId);
}
