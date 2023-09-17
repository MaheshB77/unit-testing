package com.mahesh.junitdemo.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    @DisplayName("Return Fizz if number is divisible by 3")
    @Test
    void returnFizzIfDivisibleByThree() {
        String expected = "Fizz";
        assertEquals(expected, FizzBuzz.compute(3));
    }

    @DisplayName("Return Buzz if number is divisible by 5")
    @Test
    void returnBuzzIfDivisibleByFive() {
        String expected = "Buzz";
        assertEquals(expected, FizzBuzz.compute(5));
    }

    @DisplayName("Return FizzBuzz if number is divisible by 3 and 5")
    @Test
    void returnFizzBuzzIfDivisibleByThreeAndFive() {
        String expected = "FizzBuzz";
        assertEquals(expected, FizzBuzz.compute(15));
    }

    @DisplayName("Return number itself if it is divisible by 3 or 5")
    @Test
    void ifNotDivisibleByThreeOrFive() {
        String expected = "1";
        assertEquals(expected, FizzBuzz.compute(1));
    }
}
