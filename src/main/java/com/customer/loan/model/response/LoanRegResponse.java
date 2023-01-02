package com.customer.loan.model.response;


import com.customer.loan.constants.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanRegResponse {
  StatusEnum statusEnum;
}
