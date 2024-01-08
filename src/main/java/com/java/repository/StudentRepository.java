package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.binding.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> 
{

}
