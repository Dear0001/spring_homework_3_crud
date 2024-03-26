package org.example.homework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course {
    private Integer course_id;
    private String course_name;
    private String description;
    private Integer instructor_id;
}
