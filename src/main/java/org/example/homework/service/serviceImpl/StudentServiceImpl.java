package org.example.homework.service.serviceImpl;

import org.example.homework.model.Course;
import org.example.homework.model.Instructor;
import org.example.homework.model.Student;
import org.example.homework.model.dto.Request.StudentRequest;
import org.example.homework.repository.CourseRepository;
import org.example.homework.repository.InstructorRepository;
import org.example.homework.repository.StudentRepository;
import org.example.homework.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;

    public StudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository, InstructorRepository instructorRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Student> getAllStudents(Integer pageSize, Integer pageNumber) {
        return studentRepository.getAllStudent(pageSize, pageNumber);
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentRepository.getStudentById(id);
    }

    @Override
    public Integer postStudent(StudentRequest studentRequest) {
        Integer id = studentRepository.postStudent(studentRequest);
        return studentRepository.studentCourse(id, studentRequest.getCourse_id());
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteStudent(id);
    }

    @Override
    public void updateStudent(Integer id, StudentRequest studentRequest) {
         studentRepository.updateStudent(id, studentRequest);
    }


}
