package com.mashibing.cycleDependency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class B {

    @Autowired
    C c;

    public void testB() {
        System.out.println("im b");
    }
}
