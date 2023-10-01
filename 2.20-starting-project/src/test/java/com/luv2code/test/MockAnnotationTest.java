package com.luv2code.test;

import com.luv2code.component.MvcTestingExampleApplication;
import com.luv2code.component.utils.ApplicationUtil;
import com.luv2code.component.service.ApplicationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
}
