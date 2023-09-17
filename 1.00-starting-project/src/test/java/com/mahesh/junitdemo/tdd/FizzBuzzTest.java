package com.mahesh.junitdemo.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @DisplayName("Test the FizzBuzz with multiple inputs")
    @ParameterizedTest(name = "input={0}, expectedOutput={1}")
    @CsvSource({
            "1,1",
            "2,2",
            "3,Fizz",
            "4,4",
            "5,Buzz",
            "6,Fizz",
            "7,7"
    })
    void testFizzFuzz(int input, String expectedOutput) {
        assertEquals(expectedOutput, FizzBuzz.compute(input));
    }
}
