package com.mashibing.cycleDependency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class A {

    @Autowired
    B b;


    public void testA() {
        System.out.println("im a");
    }
}
