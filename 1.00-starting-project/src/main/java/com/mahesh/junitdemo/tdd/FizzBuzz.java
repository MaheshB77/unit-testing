package com.mahesh.junitdemo.tdd;

public class FizzBuzz {

    public static String compute(int i) {

        // Approach 1
//        if ((i % 3 == 0) && (i % 5 == 0)) {
//            return "FizzBuzz";
//        } else if (i % 3 == 0) {
//            return "Fizz";
//        } else if (i % 5 == 0) {
//            return "Buzz";
//        }
//        return Integer.toString(i);

        // Approach 2
        StringBuilder result = new StringBuilder();
        if (i % 3 == 0) {
            result.append("Fizz");
        }
        if (i % 5 == 0) {
            result.append("Buzz");
        }
        if (result.length() == 0) {
            result.append(i);
        }
        return result.toString();
    }
}
