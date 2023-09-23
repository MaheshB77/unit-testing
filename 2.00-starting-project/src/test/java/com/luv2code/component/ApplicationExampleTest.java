package com.luv2code.component;

import com.luv2code.component.models.CollegeStudent;
import com.luv2code.component.models.StudentGrades;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ApplicationExampleTest {

    @Value("${info.school.name}")
    private String schoolName;

    @Value("${info.app.name}")
    private String appName;

    @Value("${info.app.description}")
    private String appDescription;

    @Value("${info.app.version}")
    private String appVersion;

    private static int count = 0;

    @Autowired
    private CollegeStudent student;

    @Autowired
    private StudentGrades studentGrades;

    @Autowired
    private ApplicationContext applicationContext;

    @BeforeEach
    public void beforeEach() {
        count += 1;
        student.setFirstname("Mahesh");
        student.setLastname("Bansode");
        student.setEmailAddress("mbansode7696@gmail.com");
        studentGrades.setMathGradeResults(Arrays.asList(90.5, 85.5, 93.2, 87.3));
        student.setStudentGrades(studentGrades);

        System.out.println("App name :: " + appName +
            " , App description :: " + appDescription +
            " , App version :: " + appVersion +
            " , School name :: " + schoolName
        );
        System.out.println("Execution method number :: " + count);
    }

    @DisplayName("Check addition of grades")
    @Test
    void gradeSum() {
        assertEquals(356.5, studentGrades.addGradeResultsForSingleClass(
                student.getStudentGrades().getMathGradeResults()
        ));
    }

    @DisplayName("Is grade greater")
    @Test
    void isGradeGreater() {
        assertTrue(
            studentGrades.isGradeGreater(70, 60),
            "Grade 70 should be greater than 60"
        );
        assertFalse(
            studentGrades.isGradeGreater(70, 70),
            "Grade 70 is not greater than 70"
        );
        assertTrue(
            studentGrades.isGradeGreater(40, -70),
            "Grade 40 is not greater than -70"
        );
    }

    @DisplayName("Check that CollegeStudent is a prototype bean")
    @Test
    void checkPrototype() {
        CollegeStudent collegeStudent = applicationContext.getBean("collegeStudent", CollegeStudent.class);
        assertNotSame(student, collegeStudent);
    }
}
