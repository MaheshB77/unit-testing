package com.mahesh.junitdemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DemoUtilsTest {

    @Test
    void getAcademyInList() {
    }

    @Test
    void getAcademy() {
    }

    @Test
    void getAcademyDuplicate() {
    }

    @Test
    void getFirstThreeLettersOfAlphabet() {
    }

    @Test
    void add() {
        DemoUtils demoUtils = new DemoUtils();
        assertEquals(10, demoUtils.add(5, 5), "5+5 must be 10");
        assertEquals(6, demoUtils.add(10, -4));
        assertNotEquals(14, demoUtils.add(10, -4));
    }

    @Test
    void multiply() {
    }

    @Test
    void checkNull() {
        DemoUtils demoUtils = new DemoUtils();
        String str1 = null;
        String str2 = "Mahesh";
        assertNull(demoUtils.checkNull(str1));
        assertNotNull(demoUtils.checkNull(str2));
    }

    @Test
    void isGreater() {
    }

    @Test
    void throwException() {
    }

    @Test
    void checkTimeout() {
    }
}