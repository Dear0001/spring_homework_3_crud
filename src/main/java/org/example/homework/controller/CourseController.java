package org.example.homework.controller;

import org.example.homework.model.Course;
import org.example.homework.model.dto.Request.CourseRequest;
import org.example.homework.model.dto.Response.APIResponse;
import org.example.homework.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<?> postCourse(CourseRequest courseRequest) {
        Course course = courseService.postCourse(courseRequest);

        return ResponseEntity.ok(
                new APIResponse<Course>(
                        "Course has been successfully created.",
                        201,
                        course,
                        HttpStatus.CREATED,
                        LocalDateTime.now()
                )
        );
    }
//////////////////////////////
    @PutMapping("{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer id, @RequestBody CourseRequest courseRequest) {
        Course course = courseService.updateCourse(id, courseRequest);
        return ResponseEntity.ok(
                new APIResponse<>(
                        "Course has been successfully updated.",
                        200,
                        course,
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );

    }

    @GetMapping("getAllCourses")
    public ResponseEntity<?> getAllCourses(@RequestParam(required = false, defaultValue = "1") String page,
                                           @RequestParam(required = false, defaultValue = "5") String size) {
        int pageNumber = Integer.parseInt(page);
        int pageSize = Integer.parseInt(size);

        List<Course> courses = courseService.getAllCourses(pageNumber, pageSize);
        return ResponseEntity.ok(
                new APIResponse<>(
                        "Courses have been successfully fetched.",
                        200,
                        courses,
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCourseById(@PathVariable Integer id) {
        Course course = courseService.getCourseById(id);
        return ResponseEntity.ok(
                new APIResponse<>(
                        "Course has been successfully fetched.",
                        200,
                        course,
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCourseById(@PathVariable Integer id) {
        courseService.deleteById(id);
        APIResponse<?> response = APIResponse.builder()
                .message("Course has been successfully removed.")
                .code(200)
                .payload(null)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

}
