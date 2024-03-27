package org.example.homework.repository;

import org.apache.ibatis.annotations.*;
import org.example.homework.model.Student;
import org.example.homework.model.dto.Request.StudentRequest;

import java.util.List;

@Mapper
public interface StudentRepository {

    @Select(""" 
        SELECT s.*, sc.course_id
        FROM students s
        JOIN student_courses sc ON s.student_id = sc.student_id
        LIMIT #{pageSize} OFFSET #{pageSize} * (#{pageNumber} - 1)
        """)
    @Result(property = "course", column = "course_id", many = @Many(select = "org.example.homework.repository.CourseRepository.getCourseById"))
    List<Student> getAllStudent(@Param("pageSize") Integer pageSize, @Param("pageNumber") Integer pageNumber);

    @Select("""
        SELECT s.*, sc.course_id
        FROM students s
        JOIN student_courses sc ON s.student_id = sc.student_id
        WHERE s.student_id = #{Id}
        """)
    @Result(property = "course", column = "course_id", many = @Many(select = "org.example.homework.repository.CourseRepository.getCourseById"))
    Student getStudentById(Integer id);


    @Select("""
        INSERT INTO students (student_name, email, phone_number)
        VALUES (#{student_name}, #{email}, #{phone_number})
        RETURNING student_id
        """)
//    @Result(property = "course", column = "course_id", many = @Many(select = "org.example.homework.repository.CourseRepository.getCourseById"))
     Integer postStudent(StudentRequest studentRequest);

    @Insert("""
        INSERT INTO student_courses VALUES (#{studentId}, #{courseId})
        """)
    Integer studentCourse(Integer studentId, Integer courseId);
    
    @Delete("""
        DELETE FROM students
        WHERE student_id = #{id}
        """)
    void deleteStudent(Integer id);


    @Update("""
        UPDATE students
        SET student_name = #{studentRequest.student_name}, email = #{studentRequest.email}, phone_number = #{studentRequest.phone_number}
        WHERE student_id = #{id}
        """)
    void updateStudent(Integer id, StudentRequest studentRequest);
}
