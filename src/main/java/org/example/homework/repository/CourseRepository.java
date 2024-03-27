package org.example.homework.repository;

import org.apache.ibatis.annotations.*;
import org.example.homework.model.Course;
import org.example.homework.model.dto.Request.CourseRequest;

import java.util.List;

@Mapper
public interface CourseRepository {

    @Select("""
        INSERT INTO courses (course_name, description, instructor_id)
        VALUES (#{course_name}, #{description}, #{instructor_id})
        RETURNING *
        """)
    @Result(property = "instructor", column = "instructor_id", one = @One(select = "org.example.homework.repository.InstructorRepository.findInstructorById"))
    Course postCourse(CourseRequest courseRequest);

    @Select("""
        UPDATE courses
        SET course_name = #{courseRequest.course_name},
            description = #{courseRequest.description},
            instructor_id = #{courseRequest.instructor_id}
        WHERE course_id = #{id}
        RETURNING *
        """)
    @Result(property = "instructor", column = "instructor_id", one = @One(select = "org.example.homework.repository.InstructorRepository.findInstructorById"))
    Course updateCourse(Integer id, CourseRequest courseRequest);

    @Select("""
        SELECT * FROM courses
        WHERE course_id = #{id}
        """)
    @Result(property = "instructor", column = "instructor_id", one = @One(select = "org.example.homework.repository.InstructorRepository.findInstructorById"))
    Course getCourseById(Integer id);

    @Delete("""
        DELETE FROM courses
        WHERE course_id = #{course_id}
        """)
    void deleteById(Integer id);

    @Select("""
        SELECT * FROM courses ORDER BY course_id
        LIMIT #{size} OFFSET #{size} * (#{page} - 1)
        """)
    @Result(property = "instructor", column = "instructor_id", one = @One(select = "org.example.homework.repository.InstructorRepository.findInstructorById"))
    List<Course> getAllCourses(int page, int size);

}
