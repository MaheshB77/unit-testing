package com.luv2code.component.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.luv2code.component.utils.ApplicationUtil;

public class ApplicationService {

    @Autowired
    private ApplicationUtil applicationUtil;

    public int cube(int number) {
        int square = applicationUtil.square(number);
        return square * number;
    }

    public String numberToString(Integer number) {
        String numString = applicationUtil.toString(number);
        return "Number :: " + numString;
    }

}
