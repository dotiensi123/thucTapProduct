package com.example.QuanLySinhVien.service.Registration;

import com.example.QuanLySinhVien.dto.RegistrationDto;
import com.example.QuanLySinhVien.dto.ScheduleDto;
import com.example.QuanLySinhVien.entity.*;
import com.example.QuanLySinhVien.exception.notFoundException;
import com.example.QuanLySinhVien.repo.RegistrationRepo;
import com.example.QuanLySinhVien.repo.SectionRepo;
import com.example.QuanLySinhVien.repo.StudentRepo;
import com.example.QuanLySinhVien.service.Room.RoomService;
import com.example.QuanLySinhVien.service.Shift.ShiftService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RegistrationServiceImpl implements RegistrationService{
    private final ShiftService shiftService;
    private final RoomService roomService;
    private final RegistrationRepo registrationRepo;
    private final StudentRepo studentRepo;
    private final SectionRepo sectionRepo;
    private final ModelMapper mapper;
    @Override
    public String saveRegistration(RegistrationDto registrationDto) {
        Section section = sectionRepo.findSectionById(registrationDto.getSectionId());
        Student student = studentRepo.findStudentById(registrationDto.getStudentId());
        if(section!=null && student != null){
            Registration registration1 = registrationRepo.findRegistrationByStudentIdAndShiftIdAndRoomId(registrationDto.getStudentId()
                    ,section.getRoomId(),section.getShiftId());
            if (registration1==null){
                Registration registration = mapper.map(registrationDto,Registration.class);
                registration.setSection(section);
                registration.setStudent(student);
                registrationRepo.save(registration);
                return "OK";
            }
            else return "trung thoi khoa bieu";
        }
        return "ko ton tai";
    }

    @Override
    public List<ScheduleDto> findRegistrationsByStudentId(String studentId) {
        List<Registration> registrations = registrationRepo.findRegistrationsByStudentId(studentId);
        if(registrations.isEmpty()){
            throw new notFoundException(200,"don't have");
        }
        List<ScheduleDto> scheduleDtos = new ArrayList<>();
        for(Registration registration:registrations){
            ScheduleDto scheduleDto = new ScheduleDto();
            Section section = registration.getSection();
            Shift shift = shiftService.findShiftById(section.getShiftId());
            Room room = roomService.findRoomById(section.getRoomId());
            scheduleDtos.add(ScheduleDto.builder()
                    .sectionId(section.getId())
                    .date(shift.getDate())
                    .startTime(shift.getStartTime())
                    .endTime(shift.getEndTime()).build());
        }
        return scheduleDtos;
    }

    @Override
    public List<RegistrationDto> findAllRegistrationByStudentIdAndSemesterId(String studentId, int semesterId) {
        List<Registration> registrations = registrationRepo.findAllRegistrationByStudentIdAndSemesterId(studentId,semesterId);
        if(registrations.isEmpty()){
            return null;
        }
        else{
            List<RegistrationDto> registrationDtos = new ArrayList<>();
            for (Registration registration: registrations){
                RegistrationDto registrationDto = mapper.map(registration,RegistrationDto.class);
                registrationDto.setStudentId(studentId);
                registrationDto.setSectionId(registration.getSection().getId());
                registrationDtos.add(registrationDto);
            }
            return registrationDtos;
        }
    }
}
