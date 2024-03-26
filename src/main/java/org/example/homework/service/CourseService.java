package org.example.homework.service;

import org.example.homework.model.Course;
import org.example.homework.model.dto.Request.CourseRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    Course postCourse(CourseRequest courseRequest);
    Course updateCourse(Integer id, CourseRequest courseRequest);

    Course getCourseById(Integer id);
    void deleteById(Integer id);

    List<Course> getAllCourses(int pageNumber, int pageSize);
}
