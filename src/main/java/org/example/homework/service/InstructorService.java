package org.example.homework.service;

import org.example.homework.model.Instructor;
import org.example.homework.model.dto.Request.InstructorRequest;

import java.util.List;

public interface InstructorService {

    List<Instructor> getAllInstructors();

    Instructor getInstructorById(Integer id);
    Instructor postInstructor(InstructorRequest instructorRequest);
    void updateInstructor(Integer id, InstructorRequest instructorRequest);
    void deleteInstructor(Integer id);
}
