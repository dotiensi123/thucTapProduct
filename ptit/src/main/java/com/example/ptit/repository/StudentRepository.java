package com.example.ptit.repository;

import com.example.ptit.entity.Student;
import com.example.ptit.specification.StudentSpecifications;
import org.hibernate.type.SpecialOneToOneType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,String>, JpaSpecificationExecutor<Student> {
    Student findStudentByStudentCode(String studentCode);

    List<Student> findStudentByAddressId(String addressId);

    default List<Student> findStudentByNameStartWith(String studentName){
        Specification<Student> specification = Specification.where(StudentSpecifications.nameStartWith(studentName));
        return findAll(specification);
    }
}
