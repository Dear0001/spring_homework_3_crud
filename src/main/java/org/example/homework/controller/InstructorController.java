package org.example.homework.controller;

import org.example.homework.model.dto.Response.APIResponse;
import org.example.homework.model.Instructor;
import org.example.homework.model.dto.Request.InstructorRequest;
import org.example.homework.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }
    @GetMapping
    public ResponseEntity<?> getAllInstructors() {
        List<Instructor> instructor = instructorService.getAllInstructors();
        APIResponse<List<Instructor>> response = new APIResponse<>(
                "All instructors have been successfully fetched.",
                200,
                instructor,
                HttpStatus.OK,
                LocalDateTime.now()
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getInstructorById(@PathVariable Integer id) {
        Instructor instructor = instructorService.getInstructorById(id);
        if (instructor != null) {
            APIResponse<Instructor> response = new APIResponse<>(
                    "Instructor has been successfully fetched.",
                    200,
                    instructor,
                    HttpStatus.OK,
                    LocalDateTime.now()
            );
            return ResponseEntity.ok(response);
        } else {
            APIResponse<Instructor> response = new APIResponse<>(
                    "Instructor with ID " + id + " not found.",
                    404,
                    null,
                    HttpStatus.NOT_FOUND,
                    LocalDateTime.now()
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(response);
        }
    }
    @PostMapping
    public ResponseEntity<APIResponse<Instructor>> postInstructor(@RequestBody InstructorRequest instructorRequest) {
        Instructor instructor = instructorService.postInstructor(instructorRequest);
        APIResponse<Instructor> response = new APIResponse<>(
                "Instructor has been successfully created.",
                201,
                instructor,
                HttpStatus.CREATED,
                LocalDateTime.now()
        );
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateInstructor(@PathVariable Integer id, @RequestBody InstructorRequest instructorRequest) {
        instructorService.updateInstructor(id, instructorRequest);
        APIResponse<Instructor> response = new APIResponse<>(
                "Instructor has been successfully updated.",
                200,
                instructorService.getInstructorById(id),
                HttpStatus.OK,
                LocalDateTime.now()
        );
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable Integer id) {
        instructorService.deleteInstructor(id);
        return ResponseEntity.ok().build();
    }
}
