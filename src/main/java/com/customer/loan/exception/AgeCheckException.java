package com.customer.loan.exception;

public class AgeCheckException extends RuntimeException
{
    public AgeCheckException()
    {
        super("The Age is should be min=18 and max=60");
    }
}
