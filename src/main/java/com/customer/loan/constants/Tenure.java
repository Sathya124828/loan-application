package com.customer.loan.constants;

public enum Tenure
{
    MONTH_12(12),MONTH_24(24),MONTH_36(36),MONTH_48(48),MONTH_60(60);
    private final Integer duration;
    Tenure(final Integer newValue)
    {
        duration= newValue;
    }
    public int getValue()
    {
        return duration;
    }
}
