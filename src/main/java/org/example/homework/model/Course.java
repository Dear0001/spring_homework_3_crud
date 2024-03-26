package org.example.homework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course {
    private int course_id;
    private String course_name;
    private String description;
    private Instructor instructor;
}
