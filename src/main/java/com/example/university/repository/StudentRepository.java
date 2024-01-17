package com.example.university.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.university.model.Professor;
import com.example.university.model.Student;

public interface StudentRepository {
    ArrayList<Student> getStudents();

    Student getStudentById(int studentId);

    Student addStudent(Student student);

    Student updateStudent(int studentId, Student student);

    void deleteStudent(int studentId);

    List<Professor> getStudentProfessors(int studentId);
}