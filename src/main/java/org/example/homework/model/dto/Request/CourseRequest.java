package org.example.homework.model.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseRequest {
    private String course_name;
    private String description;
    private Integer instructor_id;

}
