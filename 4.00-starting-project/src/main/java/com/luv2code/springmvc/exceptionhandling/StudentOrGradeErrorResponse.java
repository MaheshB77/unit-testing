package com.luv2code.springmvc.exceptionhandling;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentOrGradeErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
