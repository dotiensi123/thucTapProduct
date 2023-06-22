package com.example.QuanLySinhVien.repo;

import com.example.QuanLySinhVien.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepo extends JpaRepository<Registration,Long> {
    @Query("SELECT r FROM Registration r where r.student.id = :studentId and r.section.roomId = :roomId and r.section.shiftId = :shiftId")
    Registration findRegistrationByStudentIdAndShiftIdAndRoomId(@Param("studentId") String studentId,
                                                                 @Param("roomId") String roomId,
                                                                @Param("shiftId") int shiftId);
    @Query(value = "SELECT r from Registration r where r.student.id = :studentId")
    List<Registration> findRegistrationsByStudentId(@Param("studentId") String studentId);

    Registration findRegistrationsById(long id);

    @Query("select r from Registration r where r.student.id = :studentId and r.semesterId = :semesterId")
    List<Registration> findAllRegistrationByStudentIdAndSemesterId(@Param("studentId") String studentId,
                                                      @Param("semesterId") int semesterId);

    @Query("select r from Registration r where r.semesterId = :semesterId")
    List<Registration> findAllRegistrationBySemesterId(@Param("semesterId") String semesterId);
}




