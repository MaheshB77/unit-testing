package com.luv2code.springmvc.service;

import com.luv2code.springmvc.models.CollegeStudent;
import com.luv2code.springmvc.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void createStudent(String fName, String lName, String email) {
        CollegeStudent student = new CollegeStudent(fName, lName, email);
        student.setId(1);
        studentRepository.save(student);
    }

    public boolean isStudentPresent(int id) {
        Optional<CollegeStudent> student = studentRepository.findById(id);
        return student.isPresent();
    }

    public boolean deleteStudent(int id) {
        Optional<CollegeStudent> student = studentRepository.findById(id);
        if (student.isPresent()) {
            studentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<CollegeStudent> findAll() {
        return studentRepository.findAll();
    }
}
