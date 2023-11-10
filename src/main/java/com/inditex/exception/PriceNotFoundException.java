package com.inditex.exception;

public class PriceNotFoundException extends RuntimeException {

    public PriceNotFoundException(String m) {
        super(m);
    }

}
