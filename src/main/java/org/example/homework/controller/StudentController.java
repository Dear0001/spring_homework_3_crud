package org.example.homework.controller;

import org.example.homework.model.dto.Response.APIResponse;
import org.example.homework.model.Student;
import org.example.homework.model.dto.Request.StudentRequest;
import org.example.homework.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<?> getAllStudents() {
        List<Student> student = studentService.getAllStudents();
        APIResponse<List<Student>> response = new APIResponse<>(
                "All students have been successfully fetched.",
                200,
                student,
                HttpStatus.OK,
                LocalDateTime.now()
        );
        return ResponseEntity.ok(response);
    }
//    @GetMapping("{id}")
//    public ResponseEntity<?> getStudentById(@PathVariable Integer id) {
//        Student student = studentService.getStudentById(id);
//        return ResponseEntity.ok(new APIResponse<>(
//                "Student has been successfully fetched.",
//                200,
//                student,
//                HttpStatus.OK,
//                LocalDateTime.now()
//        ));
//    }
//
//
//    @PostMapping
//    public ResponseEntity<?> postStudent(@RequestBody StudentRequest studentRequest) {
//        Student student = studentService.postStudent(studentRequest);
//        return ResponseEntity.ok(new APIResponse<>(
//                "Student has been successfully created.",
//                200,
//                student,
//                HttpStatus.OK,
//                LocalDateTime.now()
//        ));
//    }
//
//    @PutMapping("{id}")
//    public ResponseEntity<?> updateStudent(@PathVariable Integer id, @RequestBody StudentRequest studentRequest) {
//        Student student = studentService.updateStudent(id, studentRequest);
//        return ResponseEntity.ok(new APIResponse<>(
//                "Student has been successfully updated.",
//                200,
//                student,
//                HttpStatus.OK,
//                LocalDateTime.now()
//        ));
//    }
//    @DeleteMapping("{id}")
//    public ResponseEntity<?> deleteStudent(@PathVariable Integer id) {
//        studentService.deleteStudent(id);
//        return ResponseEntity.ok(new APIResponse<>(
//                "Student has been successfully deleted.",
//                200,
//                null,
//                HttpStatus.OK,
//                LocalDateTime.now()
//        ));
//    }
}
