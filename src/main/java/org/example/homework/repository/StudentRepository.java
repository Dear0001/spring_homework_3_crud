package org.example.homework.repository;

import org.apache.ibatis.annotations.*;
import org.example.homework.model.Student;
import org.example.homework.model.dto.Request.StudentRequest;

import java.util.List;

@Mapper
public interface StudentRepository {
    @Select("""
        SELECT * FROM students
        """)
    @Result(property = "course", column = "course_id", one = @One(select = "org.example.homework.repository.CourseRepository.getCourseById"))
    List<Student> getAllStudent();


//    @Select("""
//        SELECT * FROM students WHERE students.student_id = #{students}
//        """)
//    Student findStudentById(@Param("students") Integer id);
//
//    @Select("""
//        INSERT INTO students (student_name, email, phone_number)
//        VALUES (#{students.student_name}, #{students.email}, #{students.phone_number})
//        RETURNING *
//        """)
//    Student postStudent(@Param("students") StudentRequest studentRequest);
//
//
//    @Select("""
//        UPDATE students
//        SET student_name = #{student.student_name}, email = #{student.email}, phone_number = #{student.phone_number}
//        WHERE students.student_id = #{id}
//        RETURNING *
//        """)
//    Student updateStudent(Integer id, @Param("student") StudentRequest studentRequest);
//
//    @Delete("""
//        DELETE FROM students WHERE students.student_id = #{students}
//        """)
//    void deleteStudent(@Param("students") Integer id);
}
