package com.mashibing.cycleDependency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class C {

    @Autowired
    A a;

}
