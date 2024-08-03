package com.program.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.program.entity.Student;

public interface studentRepository extends JpaRepository<Student, Integer>
{
    
}
