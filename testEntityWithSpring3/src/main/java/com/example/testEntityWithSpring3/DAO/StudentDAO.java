package com.example.testEntityWithSpring3.DAO;

import com.example.testEntityWithSpring3.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDAO extends JpaRepository<StudentEntity,Long> {
    StudentEntity findOneById (String Id);
}
