package com.example.university.controller;

import com.example.university.model.Course;
import com.example.university.model.Professor;
import com.example.university.model.Student;
import com.example.university.service.ProfessorJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProfessorController {
    @Autowired
    private ProfessorJpaService professorJpaService;

    @GetMapping("/students/professors")
    public ArrayList<Professor> getProfessors() {
        return professorJpaService.getProfessors();
    }

    @GetMapping("/students/professors/{professorId}")
    public Professor getProfessorById(@PathVariable("professorId") int professorId) {
        return professorJpaService.getProfessorById(professorId);
    }

    @PostMapping("/students/professors")
    public Professor addProfessor(@RequestBody Professor professor) {
        return professorJpaService.addProfessor(professor);
    }

    @PutMapping("/students/professors/{professorId}")
    public Professor updateProfessor(@PathVariable("professorId") int professorId, @RequestBody Professor professor) {
        return professorJpaService.updateProfessor(professorId, professor);
    }

    @DeleteMapping("/students/professors/{professorId}")
    public void deleteProfessor(@PathVariable("professorId") int professorId) {
        professorJpaService.deleteProfessor(professorId);
    }

    @GetMapping("/professors/{professorId}/courses")
    public List<Course> getProfessorCourses(@PathVariable("professorId") int professorId) {
        return professorJpaService.getProfessorCourses(professorId);
    }

    @GetMapping("/professors/{professorId}/students")
    public List<Student> getProfessorStudents(@PathVariable("professorId") int professorId) {
        return professorJpaService.getProfessorStudents(professorId);
    }
}