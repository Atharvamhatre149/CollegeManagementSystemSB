package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {
    // Custom query methods, if needed
}
