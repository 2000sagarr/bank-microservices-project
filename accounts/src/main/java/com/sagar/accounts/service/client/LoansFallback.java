package com.sagar.accounts.service.client;

import com.sagar.accounts.dto.LoansDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class LoansFallback implements LoansFeignClient{
    @Override
    public ResponseEntity<LoansDto> fetchLoanDetails(String correaltionId, String mobileNumber) {
//        if any issue occur in loans microservices instead of exception return some data;
        return null;
    }
}
