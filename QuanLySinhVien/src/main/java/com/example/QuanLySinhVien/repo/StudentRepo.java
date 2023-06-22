package com.example.QuanLySinhVien.repo;

import com.example.QuanLySinhVien.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,String> {
    Student findStudentById(String id);

}
