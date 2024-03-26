package org.example.homework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Instructor {
    private int instructor_id;
    private String instructor_name;
    private String email;
}
