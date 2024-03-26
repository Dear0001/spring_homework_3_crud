package org.example.homework.repository;

import org.apache.ibatis.annotations.*;
import org.example.homework.model.Instructor;
import org.example.homework.model.dto.Request.InstructorRequest;

import java.util.List;

@Mapper
public interface InstructorRepository {

    @Select("""
    SELECT * FROM instructors ORDER BY instructor_id ASC""")
    List<Instructor> getAllInstructors();

    @Select("""
    SELECT * FROM instructors WHERE instructor_id = #{id}""")
    Instructor findInstructorById(Integer id);

    @Select("""
   INSERT INTO instructors (instructor_name, email) VALUES (#{instructor_name}, #{email}) RETURNING *;
""")
    Instructor insertInstructor(InstructorRequest instructorRequest);

    @Update("""
       UPDATE instructors
       SET instructor_name = #{instructor.instructor_name}, email = #{instructor.email}
       WHERE instructor_id = #{id}
       RETURNING *
   """)

    void updateInstructor(Integer id,@Param("instructor") InstructorRequest instructorRequest);

    @Delete("""
    DELETE FROM instructors WHERE instructor_id = #{id}
       \s""")
    void deleteInstructor(Integer id);
}

