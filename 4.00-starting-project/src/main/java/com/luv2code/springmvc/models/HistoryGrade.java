package com.luv2code.springmvc.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "history_grade")
@Getter
@Setter
@NoArgsConstructor
public class HistoryGrade implements Grade {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="student_id")
    private int studentId;

    @Column(name="grade")
    private double grade;

    public HistoryGrade(double grade) {
        this.grade = grade;
    }

}
