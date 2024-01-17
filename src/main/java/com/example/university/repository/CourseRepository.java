package com.example.university.repository;

import com.example.university.model.Course;
import com.example.university.model.Professor;
import java.util.ArrayList;

public interface CourseRepository {
    ArrayList<Course> getCourses();

    Course getCourseById(int courseId);

    Course addCourse(Course course);

    Course updateCourse(int courseId, Course course);

    void deleteCourse(int courseId);

    Professor getCourseProfessor(int courseId);
}