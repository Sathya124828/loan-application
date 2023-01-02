package com.customer.loan.service;
import com.customer.loan.constants.CountryEnum;
import com.customer.loan.constants.SalaryEnum;
import com.customer.loan.constants.StatusEnum;
import com.customer.loan.exception.AgeCheckException;
import com.customer.loan.exception.NameCheckException;
import com.customer.loan.exception.NationalIdCheckException;
import com.customer.loan.model.entity.LoanEntity;
import com.customer.loan.model.repository.LoanRepository;
import com.customer.loan.model.request.LoanRequest;
import com.customer.loan.model.response.LoanResponse;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.customer.loan.constants.Constant.*;

@Service
@Slf4j
public class LoanService {
    @Autowired
    LoanRepository loanRepository;
    @Autowired
    ModelMapper mapper;
    @Autowired
    InstallmentService installmentService;

    public LoanResponse loanoffers(LoanRequest loanRequest) {

        float loanInterestRate = 0;
        float loanFees = 0;
        switch (loanRequest.getTenure()) {
            case 60:
                loanInterestRate = SIXTY_RATE;
                loanFees = SIXTY_FEES;
                break;
            case 48:
                loanInterestRate = FORTY_RATE;
                loanFees = FORTY_FEES;
                break;
            case 36:
                loanInterestRate = THIRTY_RATE;
                loanFees = THIRTY_FEES;
                break;
            case 24:
                loanInterestRate = TWENTY_RATE;
                loanFees = TWENTY_FEES;
                break;
            case 12:
                loanInterestRate = TWELVE_RATE;
                loanFees = TWELVE_FEES;
                break;
            default:
                break;

        }
        int installment = installmentService.calculateInstallment(loanRequest.getLoanAmount(), loanInterestRate,loanRequest.getTenure());
        int loanAmount = installment * loanRequest.getTenure();
        int loanTotalInterest =  Math.round(loanAmount - loanRequest.getLoanAmount());
        log.info(String.valueOf(loanTotalInterest) + loanRequest.getTenure());
        return new LoanResponse(null, installment, loanInterestRate, loanTotalInterest, loanFees, (loanAmount + loanFees));
    }

//get mapping

    public List<String> tenuredetails()
    {
        ArrayList<String> month = new ArrayList<>();
        month.add("MONTH-60");
        month.add("MONTH_48");
        month.add("MONTH-36");
        month.add("MONTH-24");
        month.add("MONTH-12");
        return month;
    }
//post mapping


public LoanEntity loanRegistration(@RequestParam CountryEnum countryEnum, @RequestParam String name, @RequestParam int age, @RequestParam Long nationalid, @RequestParam SalaryEnum salaryEnum, @RequestParam float loanamount, @RequestParam int tenure) {
    float loanInterestRate = 0;
    float loanFees = 0;
    switch (tenure)
    {
        case 60:
            loanInterestRate = SIXTY_RATE;
            loanFees = SIXTY_FEES;
            break;
        case 48:
            loanInterestRate = FORTY_RATE;
            loanFees = FORTY_FEES;
            break;
        case 36:
            loanInterestRate = THIRTY_RATE;
            loanFees = THIRTY_FEES;
            break;
        case 24:
            loanInterestRate = TWENTY_RATE;
            loanFees = TWENTY_FEES;
            break;
        case 12:
            loanInterestRate = TWELVE_RATE;
            loanFees = TWELVE_FEES;
            break;
        default:
            break;
    }
    int installment = installmentService.calculateInstallment(loanamount, loanInterestRate,tenure);
    int loanAmount = installment * tenure;
    int loanTotalInterest = Math.round(loanAmount-loanamount);
    log.info(String.valueOf(loanTotalInterest) + tenure);
    LoanEntity loanEntity=new LoanEntity();
    if (name.length() >= 3 && name.length() <= 20)
    {
        loanEntity.setName(name);
    } else
    {
        throw new NameCheckException();
    }
    if (age >= 18 && age <= 60)
    {
        loanEntity.setAge(age);

    } else
    {
        throw new AgeCheckException();
    }
    String s = Long.toString(nationalid);
    if(s.length()==10)
    {
        loanEntity.setNationalid(nationalid);
    }
    else
    {
        throw new NationalIdCheckException();
    }

      loanEntity.setNationalid(nationalid);
      loanEntity.setTenure(tenure);
      loanEntity.setSalaryEnum(salaryEnum);
      loanEntity.setCountryEnum(countryEnum);
      loanEntity.setCreatedBy(loanEntity.getName());
      loanEntity.setCreatedDate(LocalDateTime.now());
      loanEntity.setInstallment(installment);
      loanEntity.setInterest(loanInterestRate);
      loanEntity.setTotalInterestAmt(loanTotalInterest);
      loanEntity.setFee(loanFees);
      loanEntity.setLoanamount(loanamount);
      loanEntity.setTotal(loanAmount+loanFees);
      loanEntity.setStatusEnum(StatusEnum.CONFIRMED);
      loanRepository.save(loanEntity);
      log.info(" the values are stored");
      return  loanEntity;
   }
}






