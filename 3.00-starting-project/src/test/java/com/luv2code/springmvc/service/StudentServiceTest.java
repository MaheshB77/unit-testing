package com.luv2code.springmvc.service;

import com.luv2code.springmvc.models.CollegeStudent;
import com.luv2code.springmvc.repository.StudentRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private JdbcTemplate jdbc;

    @BeforeEach
    public void setup() {
        jdbc.execute("INSERT INTO student(id, firstname, lastname, email_address) " +
                "VALUES(2, 'Mahesh', 'Bansode', 'mahesh_bansode@gmail.com')");
    }

    @AfterEach
    public void cleanup() {
        jdbc.execute("DELETE FROM student");
    }

    @DisplayName("Creates new student")
    @Test
    public void createStudent() {
        String email = "mbansode7696@gmail.com";
        studentService.createStudent("Mahesh", "Bansode", email);
        CollegeStudent collegeStudent = studentRepository.findByEmailAddress(email);
        assertEquals(email, collegeStudent.getEmailAddress());
    }

    @DisplayName("Checks is student is present or not")
    @Test
    public void isStudentPresent() {
        assertTrue(studentService.isStudentPresent(2));
        assertFalse(studentService.isStudentPresent(0));
    }

    @DisplayName("Delete a student")
    @Test
    public void deleteStudent() {
        assertTrue(studentService.deleteStudent(2));
        assertFalse(studentService.deleteStudent(5));
    }

    @DisplayName("Get all students")
    @Test
    @Sql("/setup.sql")
    public void findAll() {
        assertEquals(5, studentService.findAll().size());
    }
}