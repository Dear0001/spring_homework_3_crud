package org.example.homework.service.serviceImpl;

import org.example.homework.model.Instructor;
import org.example.homework.model.dto.Request.InstructorRequest;
import org.example.homework.repository.InstructorRepository;
import org.example.homework.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructor> getAllInstructors(int pageSize, int pageNumber) {
        return instructorRepository.getAllInstructors(pageSize, pageNumber);
    }

    @Override
    public Instructor getInstructorById(Integer id) {
        return instructorRepository.findInstructorById(id);
    }

    @Override
    public Instructor postInstructor(InstructorRequest instructorRequest) {
        return instructorRepository.insertInstructor(instructorRequest);
    }

    @Override
    public void updateInstructor(Integer id, InstructorRequest instructorRequest) {
        instructorRepository.updateInstructor(id, instructorRequest);
    }

    @Override
    public void deleteInstructor(Integer id) {
        instructorRepository.deleteInstructor(id);
    }

}
