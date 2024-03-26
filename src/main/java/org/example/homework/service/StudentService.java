package org.example.homework.service;


import org.example.homework.model.Student;
import org.example.homework.model.dto.Request.StudentRequest;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student getStudentById(Integer id);
    Student postStudent(StudentRequest studentRequest);
    Student updateStudent(Integer id, StudentRequest studentRequest);

    void deleteStudent(Integer id);
}
