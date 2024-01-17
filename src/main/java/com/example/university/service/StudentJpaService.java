package com.example.university.service;

import com.example.university.model.Professor;
import com.example.university.model.Student;
import com.example.university.repository.ProfessorJpaRepository;
import com.example.university.repository.StudentJpaRepository;
import com.example.university.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StudentJpaService implements StudentRepository {

    @Autowired
    private ProfessorJpaRepository professorJpaRepository;

    @Autowired
    private StudentJpaRepository studentJpaRepository;

    public ArrayList<Student> getStudents() {
        List<Student> studentList = studentJpaRepository.findAll();
        ArrayList<Student> students = new ArrayList<>(studentList);
        return students;
    }

    public Student getStudentById(int studentId) {
        try {
            Student student = studentJpaRepository.findById(studentId).get();
            return student;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Student addStudent(Student student) {
        List<Integer> professorIds = new ArrayList<>();
        for (Professor professor : student.getProfessors()) {
            professorIds.add(professor.getProfessorId());
        }

        List<Professor> professors = professorJpaRepository.findAllById(professorIds);
        student.setProfessors(professors);

        for (Professor professor : professors) {
            professor.getStudents().add(student);
        }

        Student savedStudent = studentJpaRepository.save(student);
        professorJpaRepository.saveAll(professors);

        return savedStudent;
    }

    public Student updateStudent(int studentId, Student student) {
        try {
            Student newStudent = studentJpaRepository.findById(studentId).get();
            if (student.getStudentName() != null) {
                newStudent.setStudentName(student.getStudentName());
            }
            if (student.getEmail() != null) {
                newStudent.setEmail(student.getEmail());
            }
            if (student.getProfessors() != null) {
                List<Professor> professors = newStudent.getProfessors();
                for (Professor professor : professors) {
                    professor.getStudents().remove(newStudent);
                }
                professorJpaRepository.saveAll(professors);
                List<Integer> newProfessorIds = new ArrayList<>();
                for (Professor professor : student.getProfessors()) {
                    newProfessorIds.add(professor.getProfessorId());
                }
                List<Professor> newProfessors = professorJpaRepository.findAllById(newProfessorIds);
                for (Professor professor : newProfessors) {
                    professor.getStudents().add(newStudent);
                }
                professorJpaRepository.saveAll(newProfessors);
                newStudent.setProfessors(newProfessors);
            }
            return studentJpaRepository.save(newStudent);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public void deleteStudent(int studentId) {
        try {
            Student student = studentJpaRepository.findById(studentId).get();

            List<Professor> professors = student.getProfessors();
            for (Professor professor : professors) {
                professor.getStudents().remove(student);
            }

            professorJpaRepository.saveAll(professors);

            studentJpaRepository.deleteById(studentId);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    public List<Professor> getStudentProfessors(int studentId) {
        try {
            Student student = studentJpaRepository.findById(studentId).get();
            return student.getProfessors();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}