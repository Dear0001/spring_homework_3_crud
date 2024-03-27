CREATE DATABASE spring_db;
CREATE TABLE instructors (
    instructor_id SERIAL PRIMARY KEY,
    instructor_name VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE courses (
    course_id SERIAL PRIMARY KEY,
    course_name VARCHAR(100),
    description VARCHAR(100),
    instructor_id INT,
    FOREIGN KEY (instructor_id) REFERENCES instructors(instructor_id)
);

CREATE TABLE student_courses (
    student_id INT,
    course_id INT,
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

CREATE TABLE students (
    student_id SERIAL PRIMARY KEY,
    student_name VARCHAR(100),
    email VARCHAR(100),
    phone_number VARCHAR(100)
);
SELECT s.student_id, s.student_name, s.email, s.phone_number
FROM students s
         JOIN student_courses sc ON s.student_id = sc.student_id
WHERE s.student_id = 5;
