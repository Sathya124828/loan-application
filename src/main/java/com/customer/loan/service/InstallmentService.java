package com.customer.loan.service;


import org.springframework.stereotype.Service;

@Service

public class InstallmentService {
    int calculateInstallment(double loanAmount,double loanInterestRate, float month)
    {
        float time = month/12;
        loanInterestRate = loanInterestRate/(12 * 100);
        time=time*12;
        Double result = (loanAmount * loanInterestRate * Math.pow(1 + loanInterestRate,time))/(Math.pow(1+ loanInterestRate, time)-1);
        return (int) Math.round(result);
         }
}
