package com.customer.loan.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanResponse {
    private String id;
    private float installment;
    private float interest;
    private float totalInterestAmt;
    private float fee;
    private float total;
}
