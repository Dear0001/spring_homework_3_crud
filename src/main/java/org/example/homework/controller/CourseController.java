package org.example.homework.controller;

import org.example.homework.service.CourseService;

public class CourseController {
    private final CourseService courseService;


    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
}
