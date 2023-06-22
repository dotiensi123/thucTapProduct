package com.example.QuanLySinhVien.repo;

import com.example.QuanLySinhVien.dto.SectionDto;
import com.example.QuanLySinhVien.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepo extends JpaRepository<Section, String> {
    Section findSectionById(String id);
    Section findSectionByShiftIdAndRoomId(int shiftId, String roomId);
    @Query("SELECT s FROM Section s WHERE s.subject.id = :subjectId")
    List<Section> findAllBySubjectId(@Param("subjectId") String subjectId);
}
