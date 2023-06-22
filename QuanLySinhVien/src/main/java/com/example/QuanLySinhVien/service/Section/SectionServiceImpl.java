package com.example.QuanLySinhVien.service.Section;

import com.example.QuanLySinhVien.dto.SectionDto;
import com.example.QuanLySinhVien.entity.Room;
import com.example.QuanLySinhVien.entity.Section;
import com.example.QuanLySinhVien.entity.Shift;
import com.example.QuanLySinhVien.entity.Subject;
import com.example.QuanLySinhVien.repo.RoomRepo;
import com.example.QuanLySinhVien.repo.SectionRepo;
import com.example.QuanLySinhVien.repo.ShiftRepo;
import com.example.QuanLySinhVien.repo.SubjectRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SectionServiceImpl implements SectionService{
    private final ShiftRepo shiftRepo;
    private final RoomRepo roomRepo;
    private final SectionRepo sectionRepo;
    private final SubjectRepo subjectRepo;
    private final ModelMapper mapper;


    @Override
    public List<SectionDto> findAllSection() {
        List<Section>sections = sectionRepo.findAll();
        List<SectionDto> sectionDtos = new ArrayList<>();
        for (Section section:sections) {
            SectionDto sectionDto = mapper.map(section, SectionDto.class);
            String id = sectionDto.getId();
            sectionDto.setSubject_id(id.substring(0,3));
            sectionDtos.add(sectionDto);
        }
        return sectionDtos;
    }

    @Override
    public Section findSectionById(String id) {
        return sectionRepo.findSectionById(id);
    }

    @Override
    public Section findSectionByShiftIdAndRoomId(int shiftId, String roomId) {
        return sectionRepo.findSectionByShiftIdAndRoomId(shiftId,roomId);
    }

    @Override
    public String addSection(SectionDto sectionDto) {
        Shift shift = shiftRepo.findShiftById(sectionDto.getShiftId());
        Room room = roomRepo.findRoomById(sectionDto.getRoomId());
        Section section = sectionRepo.findSectionByShiftIdAndRoomId(sectionDto.getShiftId(),sectionDto.getRoomId());
        if (section == null && shift != null && room != null ){
            Section section1 = mapper.map(sectionDto, Section.class);
            Subject subject = subjectRepo.findSubjectsById(sectionDto.getSubject_id());
            section1.setSubject(subject);
            sectionRepo.save(section1);
            return "ok";
        }
        return "not ok";
    }

    @Override
    public List<SectionDto> findAllBySubjectId(String subjectId) {
        List<Section> sections = sectionRepo.findAllBySubjectId(subjectId);
        List<SectionDto> sectionDtos = sections.stream().map(section -> mapper.map(section,SectionDto.class)).collect(Collectors.toList());
        return sectionDtos;
    }

}
