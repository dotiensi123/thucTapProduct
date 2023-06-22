package com.example.QuanLySinhVien.repo;

import com.example.QuanLySinhVien.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepo extends JpaRepository<Grade, Long> {
    @Query("Select g from Grade g where g.registration.id = :registrationId")
    Grade findGradeByRegistrationId(@Param("registrationId") Long registrationId);
}
