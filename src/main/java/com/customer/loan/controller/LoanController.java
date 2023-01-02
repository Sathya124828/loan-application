package com.customer.loan.controller;

import com.customer.loan.constants.CountryEnum;
import com.customer.loan.constants.SalaryEnum;
import com.customer.loan.exception.AgeCheckException;
import com.customer.loan.exception.NameCheckException;
import com.customer.loan.exception.NationalIdCheckException;
import com.customer.loan.model.entity.LoanEntity;
import com.customer.loan.model.request.LoanRequest;
import com.customer.loan.model.response.LoanResponse;
import com.customer.loan.service.LoanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@Slf4j
public class LoanController {
    @Autowired
    LoanService loanService;

    @GetMapping
    public List<String> tenuredetails() {
    return loanService.tenuredetails();
    }

    @PostMapping("/loan")
    public ResponseEntity<LoanResponse> loanOffers(@RequestBody LoanRequest loanRequest) {
    return new ResponseEntity<>(loanService.loanoffers(loanRequest), HttpStatus.OK);
    }


    @PostMapping("/register")
    public ResponseEntity<LoanEntity> loanRegistraion(@RequestParam CountryEnum countryEnum, @RequestParam String name, @RequestParam int age, @RequestParam long nationalid, @RequestParam SalaryEnum salaryEnum,@RequestParam int loanamount, @RequestParam int tenure) {

            log.info("The values are passing");
            return new ResponseEntity<>(loanService.loanRegistration(countryEnum, name, age, nationalid, salaryEnum,loanamount, tenure), HttpStatus.OK);



        }
}

