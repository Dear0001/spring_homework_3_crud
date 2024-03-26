package org.example.homework.service.serviceImpl;

import org.example.homework.model.Student;
import org.example.homework.model.dto.Request.StudentRequest;
import org.example.homework.repository.StudentRepository;
import org.example.homework.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.saveStudent();
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentRepository.findStudentById(id);
    }
    @Override
    public Student postStudent(StudentRequest studentRequest) {
        return studentRepository.postStudent(studentRequest);
    }

    @Override
    public Student updateStudent(Integer id, StudentRequest studentRequest){
        return studentRepository.updateStudent(id, studentRequest);
    }
    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteStudent(id);
    }


}
