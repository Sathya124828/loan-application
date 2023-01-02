package com.customer.loan.exception;

public class NationalIdCheckException extends RuntimeException{
    public NationalIdCheckException()
    {
        super("required 10 digits");
    }
}
