package com.mashibing.cycleDependency.service;


import com.mashibing.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);


        B b1 = applicationContext.getBean("b", B.class);
        B b2 = applicationContext.getBean("b", B.class);

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b1.c);
        System.out.println(b2.c);


//        A a1 = applicationContext.getBean("a", A.class);
//        A a2 = applicationContext.getBean("a", A.class);

//        System.out.println(a1);
//        System.out.println(a2);
//        System.out.println(a1.b);
//        System.out.println(a2.b);
        //System.out.println(b);

    }


}
