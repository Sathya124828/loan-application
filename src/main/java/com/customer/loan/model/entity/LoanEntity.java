package com.customer.loan.model.entity;

import com.customer.loan.constants.CountryEnum;
import com.customer.loan.constants.SalaryEnum;
import com.customer.loan.constants.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Loan-Application")

public class LoanEntity {
    @Id
    private String  id;
    private CountryEnum countryEnum;
    private String name;
    private int age;
    private long nationalid;
    private SalaryEnum salaryEnum;
    private int tenure;
    private float loanamount;
    private float installment;
    private float interest;
    private float totalInterestAmt;
    private float fee;
    private float total;
    private LocalDateTime createdDate;
    private String createdBy;
    private StatusEnum statusEnum;


}
