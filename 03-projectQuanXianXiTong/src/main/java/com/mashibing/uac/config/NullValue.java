package com.mashibing.uac.config;

import java.io.Serializable;

public class NullValue implements Serializable {

    static final Object INSTANCE = new NullValue();

    private static final long serialVersionUID = 1L;


    private NullValue() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

}
