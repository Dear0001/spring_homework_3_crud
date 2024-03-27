package org.example.homework.controller;

import org.example.homework.model.Instructor;
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
    public ResponseEntity<?> getAllStudent(@RequestParam(required = false, defaultValue = "1") String page,
                                           @RequestParam(required = false, defaultValue = "5") String size) {
        int pageNumber = Integer.parseInt(page);
        int pageSize = Integer.parseInt(size);
        List<Student> student = studentService.getAllStudents(pageSize, pageNumber);
        APIResponse<List<Student>> response = new APIResponse<>(
                "All instructors have been successfully fetched.",
                200,
                student,
                HttpStatus.OK,
                LocalDateTime.now()
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Integer id) {
        try {
            Student student = studentService.getStudentById(id);
            APIResponse<Student> response = new APIResponse<>(
                    "Student has been successfully fetched.",
                    200,
                    student,
                    HttpStatus.OK,
                    LocalDateTime.now()
            );
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            APIResponse<String> errorResponse = new APIResponse<>(
                    "An error occurred while processing the request.",
                    500,
                    null,
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    LocalDateTime.now()
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PostMapping
    public ResponseEntity<?> postStudent(@RequestBody StudentRequest studentRequest) {
        try {
            Integer id = studentService.postStudent(studentRequest);
            APIResponse<Integer> response = new APIResponse<>(
                    "Student has been successfully added.",
                    200,
                    id,
                    HttpStatus.OK,
                    LocalDateTime.now()
            );
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            APIResponse<String> errorResponse = new APIResponse<>(
                    "An error occurred while processing the request.",
                    500,
                    null,
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    LocalDateTime.now()
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id) {
        try {
            studentService.deleteStudent(id);
            APIResponse<String> response = new APIResponse<>(
                    "Student has been successfully deleted.",
                    200,
                    "Student has been successfully deleted.",
                    HttpStatus.OK,
                    LocalDateTime.now()
            );
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            APIResponse<String> errorResponse = new APIResponse<>(
                    "An error occurred while processing the request.",
                    500,
                    null,
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    LocalDateTime.now()
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer id, @RequestBody StudentRequest studentRequest) {
        try {
            studentService.updateStudent(id, studentRequest);
            APIResponse<String> response = new APIResponse<>(
                    "Student has been successfully updated.",
                    200,
                    "Student has been successfully updated.",
                    HttpStatus.OK,
                    LocalDateTime.now()
            );
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            APIResponse<String> errorResponse = new APIResponse<>(
                    "An error occurred while processing the request.",
                    500,
                    null,
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    LocalDateTime.now()
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}


