package com.customer.loan.exception;

public class NameCheckException extends RuntimeException {

    public NameCheckException()
    {
        super("the name length required min 3 and max 20");
    }
}
