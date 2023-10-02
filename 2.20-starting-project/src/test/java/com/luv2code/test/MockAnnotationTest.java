package com.luv2code.test;

import com.luv2code.component.MvcTestingExampleApplication;
import com.luv2code.component.service.ApplicationService;
import com.luv2code.component.utils.ApplicationUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = MvcTestingExampleApplication.class)
public class MockAnnotationTest {

    // @Mock
    @MockBean
    private ApplicationUtil applicationUtil;

    // @InjectMocks
    @Autowired
    private ApplicationService applicationService;


    @DisplayName("Test cube")
    @Test
    public void testGradeResults() {
        when(applicationUtil.square(2)).thenReturn(4);
        assertEquals(8, applicationService.cube(2));
        verify(applicationUtil, times(1)).square(2);
    }

    @DisplayName("Throw exception")
    @Test
    public void throwException() {
        when(applicationUtil.toString(null)).thenThrow(new RuntimeException());
        assertThrows(RuntimeException.class, () -> {
           applicationService.numberToString(null);
        });
    }

    @DisplayName("Number to String")
    @Test
    public void numberToString() {
        Integer inputNumber = 2;
        when(applicationUtil.toString(inputNumber)).thenReturn(inputNumber.toString());
        assertEquals("Number :: " + inputNumber, applicationService.numberToString(inputNumber));
    }

    @DisplayName("Test private method")
    @Test
    public void sum() {
        Object result = ReflectionTestUtils.invokeMethod(applicationService, "sum", 2, 4);
        assertEquals(6, result);
    }
}
