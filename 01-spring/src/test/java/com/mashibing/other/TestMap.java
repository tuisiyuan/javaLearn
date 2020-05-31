package com.mashibing.other;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestMap {

    public static void main(String[] args) {
        Map paramMap = new LinkedHashMap() {{
            put("id", 123);
            put("statusArr", "123|345|657");
        }};


        Collection values = paramMap.values();

        System.out.println(values);


    }



}
