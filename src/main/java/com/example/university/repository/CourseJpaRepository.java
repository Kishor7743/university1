package com.example.university.repository;

import com.example.university.model.Course;
import com.example.university.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseJpaRepository extends JpaRepository<Course, Integer> {
    List<Course> findByProfessor(Professor professor);
}