package com.luv2code.springmvc.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Component
@Getter
@Setter
public class StudentGrades {

    List<Grade> mathGradeResults;

    List<Grade> scienceGradeResults;

    List<Grade> historyGradeResults;

    public StudentGrades() {}

    public double addGradeResultsForSingleClass(List<Grade> grades) {
        double result = 0;
        for (Grade i : grades) {
            result += i.getGrade();
        }
        return result;
    }

    public double findGradePointAverage (List<Grade> grades ) {
        int lengthOfGrades = grades.size();
        double sum = addGradeResultsForSingleClass(grades);
        double result = sum / lengthOfGrades;

        // add a round function
        BigDecimal resultRound = BigDecimal.valueOf(result);
        resultRound = resultRound.setScale(2, RoundingMode.HALF_UP);
        return resultRound.doubleValue();

    }

}
