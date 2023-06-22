package com.example.QuanLySinhVien.service.Grade;
import com.example.QuanLySinhVien.dto.GradeDto;
import com.example.QuanLySinhVien.dto.ResultOfStudent;
import com.example.QuanLySinhVien.dto.SemesterDto;
import com.example.QuanLySinhVien.entity.Grade;
import com.example.QuanLySinhVien.entity.Registration;
import com.example.QuanLySinhVien.repo.GradeRepo;
import com.example.QuanLySinhVien.repo.RegistrationRepo;
import com.example.QuanLySinhVien.service.Registration.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService{
    private final GradeRepo gradeRepo;
    private final ModelMapper mapper;
    private final RegistrationRepo registrationRepo;
    private final RegistrationService registrationService;

    public GradeDto findGradeByRegistrationId(Long id) {
        Grade grade = gradeRepo.findGradeByRegistrationId(id);
        if (grade == null) {
            return null;
        }
        float tong = (float) (grade.getGrade1() * 0.1 + grade.getGrade2() * 0.1 + grade.getGrade3() * 0.2 + grade.getGrade4() * 0.6);
        boolean status = (tong > 4.0) ? Boolean.TRUE : Boolean.FALSE;
        GradeDto gradeDto = mapper.map(grade, GradeDto.class);
        gradeDto.setTong(tong);
        gradeDto.setStatus(status);
        gradeDto.setRegistration_id(id);
        return gradeDto;
    }

    @Override
    public String saveGrade(GradeDto gradeDto) {
        Registration registration = registrationRepo.findRegistrationsById(gradeDto.getRegistration_id());
        if (registration == null) {
            return "registration not found";
        }
        Grade grade = mapper.map(gradeDto, Grade.class);
        grade.setRegistration(registration);
        gradeRepo.save(grade);
        return "ok";
    }

    @Override
    public ResultOfStudent findResultOfStudent(String studentId, int semesterId) {
        List<Registration> registrations = registrationRepo.findAllRegistrationByStudentIdAndSemesterId(studentId, semesterId);
        if (registrations == null) {
            return null;
        }

        ResultOfStudent resultOfStudent = new ResultOfStudent();
        float tongDiem = 0;
        List<GradeDto> gradeDtos = new ArrayList<>();

        for (Registration registration : registrations) {
            Grade grade = gradeRepo.findGradeByRegistrationId(registration.getId());
            GradeDto gradeDto = new GradeDto();

            if (grade != null) {
                gradeDto = mapper.map(grade, GradeDto.class);
                float tong = (float) (grade.getGrade1() * 0.1 + grade.getGrade2() * 0.1 + grade.getGrade3() * 0.2 + grade.getGrade4() * 0.6);
                gradeDto.setTong(tong);
                gradeDto.setStatus(tong > 4.0);
                gradeDto.setRegistration_id(registration.getId());
                tongDiem += tong;
                gradeDtos.add(gradeDto);
            } else {
                gradeDtos.add(gradeDto);
            }
        }

        tongDiem /= registrations.size();
        if (tongDiem < 4.0) {
            resultOfStudent.setLoai("Yeu");
        } else if (tongDiem < 8.0) {
            resultOfStudent.setLoai("Kha");
        } else if (tongDiem < 9.0) {
            resultOfStudent.setLoai("Gioi");
        } else {
            resultOfStudent.setLoai("Xuat xac");
        }

        resultOfStudent.setStudentId(studentId);
        resultOfStudent.setTong(tongDiem);
        resultOfStudent.setGradeDtos(gradeDtos);
        return resultOfStudent;

    }

    @Override
    public List<SemesterDto> findResultSemester(float diem) {
        return null;
    }
}
