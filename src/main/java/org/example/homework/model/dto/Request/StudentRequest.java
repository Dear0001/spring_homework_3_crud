package org.example.homework.model.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentRequest {
    private String student_name;
    private String email;
    private String phone_number;
    private Integer course_id;
}
