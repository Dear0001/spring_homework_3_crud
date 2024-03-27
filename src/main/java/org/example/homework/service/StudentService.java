package org.example.homework.service;


import org.example.homework.model.Student;
import org.example.homework.model.dto.Request.StudentRequest;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents(Integer pageSize, Integer pageNumber);
    Student getStudentById(Integer id);

    Integer postStudent(StudentRequest studentRequest);
    
    void deleteStudent(Integer id);

    void updateStudent(Integer id, StudentRequest studentRequest);
}
