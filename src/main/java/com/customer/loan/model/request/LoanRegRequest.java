package com.customer.loan.model.request;

import com.customer.loan.constants.CountryEnum;
import com.customer.loan.constants.SalaryEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanRegRequest {

   private  CountryEnum countryEnum;
    private String name;
    private int age;
    private long nationalid;
    private SalaryEnum salaryEnum;
    private float loanamount;
    private int tenure;
}
