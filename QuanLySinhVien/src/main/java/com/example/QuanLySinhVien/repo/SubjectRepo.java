package com.example.QuanLySinhVien.repo;

import com.example.QuanLySinhVien.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepo extends JpaRepository<Subject,String> {
    Subject findSubjectsById(String id);
}
