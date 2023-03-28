package com.example.ptit.specification;

import com.example.ptit.entity.Student;
import org.springframework.data.jpa.domain.Specification;

public class StudentSpecifications {
    public static Specification<Student> nameStartWith(String prefix){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("studentCode"), prefix + "%");}
    public static Specification<Student> addressIdLike(String addressId){
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("addressId"), addressId+"%" );
    }
}
