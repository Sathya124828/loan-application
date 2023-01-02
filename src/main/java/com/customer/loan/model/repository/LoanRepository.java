package com.customer.loan.model.repository;

import com.customer.loan.model.entity.LoanEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends MongoRepository<LoanEntity,String> {
}
