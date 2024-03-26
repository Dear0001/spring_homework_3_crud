package org.example.homework.service.serviceImpl;

import org.example.homework.model.Course;
import org.example.homework.model.dto.Request.CourseRequest;
import org.example.homework.repository.CourseRepository;
import org.example.homework.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course postCourse(CourseRequest courseRequest) {
        return courseRepository.postCourse(courseRequest);
    }

    @Override
    public Course updateCourse(Integer id, CourseRequest courseRequest) {

        return courseRepository.updateCourse(id, courseRequest);
    }

    @Override
    public Course getCourseById(Integer id) {
        return courseRepository.getCourseById(id);
    }

    @Override
    public void deleteById(Integer id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> getAllCourses(int pageNumber, int pageSize) {
        return courseRepository.getAllCourses(pageNumber, pageSize);
    }

}
