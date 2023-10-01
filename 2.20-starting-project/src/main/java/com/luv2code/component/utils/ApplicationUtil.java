package com.luv2code.component.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

public class ApplicationUtil {

    public double addGradeResultsForSingleClass(List<Double> grades) {
        double result = 0;
        for (double i : grades) {
            result += i;
        }
        return result;
    }

    public double findGradePointAverage (List<Double> grades ) {
        int lengthOfGrades = grades.size();
        double sum = addGradeResultsForSingleClass(grades);
        double result = sum / lengthOfGrades;

        // add a round function
        BigDecimal resultRound = BigDecimal.valueOf(result);
        resultRound = resultRound.setScale(2, RoundingMode.HALF_UP);
        return resultRound.doubleValue();

    }

    public String toString(Object obj) {
        if (Objects.isNull(obj)) {
            throw new RuntimeException("Object is null");
        } else {
            return obj.toString();
        }
    }

    public int square(int number) {
        return number * number;
    }
}
