package com.mahesh.junitdemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeEach
    void beforeEach() {
        demoUtils = new DemoUtils();
    }

    @DisplayName("Checks equals and not equals")
    @Test
    void add() {
        assertEquals(10, demoUtils.add(5, 5), "5+5 must be 10");
        assertEquals(6, demoUtils.add(10, -4));
        assertNotEquals(14, demoUtils.add(10, -4));
    }

    @DisplayName("Checks null and not null")
    @Test
    void checkNull() {
        String str1 = null;
        String str2 = "Mahesh";
        assertNull(demoUtils.checkNull(str1));
        assertNotNull(demoUtils.checkNull(str2));
    }

    @DisplayName("Checks if object reference is same or not")
    @Test
    void checkSame() {
        String maheshAcademy = "Mahesh Academy";
        String maheshAcademy2 = "Mahesh Academy";
        String maheshAcademy3 = new String("Mahesh Academy");

        assertSame(maheshAcademy, maheshAcademy2);
        assertNotSame(maheshAcademy, maheshAcademy3);
    }

    @DisplayName("Checks true or false")
    @Test
    void checkTrue() {
        int grade1 = 10;
        int grade2 = 15;
        int grade3 = 20;

        assertFalse(demoUtils.isGreater(grade1, grade2));
        assertTrue(demoUtils.isGreater(grade3, grade2));
    }

    @DisplayName("Check that 2 arrays have same content (deeply)")
    @Test
    void checkArraysEquals() {
        String[] actual = {"A", "B", "C"};
        assertArrayEquals(actual, demoUtils.getFirstThreeLettersOfAlphabet());

        Person[] persons = {
            new Person("Mahesh", new Address("Pune")),
            new Person("Aishwarya", new Address("Junnar")),
            new Person("Shubhangi", new Address("Bhigwan"))
        };
        Person[] persons2 = {
                new Person("Mahesh", new Address("Pune")),
                new Person("Aishwarya", new Address("Junnar")),
                new Person("Shubhangi", new Address("Bhigwan"))
        };
        assertArrayEquals(persons, persons2);
    }

    @DisplayName("Check that 2 lists of strings have same content")
    @Test
    void checkListEquals() {
        List<String> names1 = List.of("Mahesh", "Dinesh", "Ganesh");
        List<String> names2 = List.of("Mahesh", "Dinesh", "Ganesh");

        assertLinesMatch(names1, names2);
    }

    @DisplayName("Checks that 2 iterables have same content (deeply)")
    @Test
    void checkIterablesEquals() {
        List<Person> persons = List.of(
                new Person("Mahesh", new Address("Pune")),
                new Person("Aishwarya", new Address("Junnar")),
                new Person("Shubhangi", new Address("Bhigwan"))
        );
        List<Person> persons2 = List.of(
                new Person("Mahesh", new Address("Pune")),
                new Person("Aishwarya", new Address("Junnar")),
                new Person("Shubhangi", new Address("Bhigwan"))
        );

        assertIterableEquals(persons, persons2);
    }

    @DisplayName("Check if exception is thrown")
    @Test
    void throwException() {
        assertThrows(Exception.class, () -> {
           demoUtils.throwException(-1);
        });

        assertDoesNotThrow(() -> {
            demoUtils.throwException(10);
        });
    }

    @DisplayName("Check if method is executed in particular time")
    @Test
    void checkTimeout() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            demoUtils.checkTimeout();
        });
    }

}