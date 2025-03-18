package com.sagar.accounts.service.impl;

import com.sagar.accounts.dto.AccountsDto;
import com.sagar.accounts.dto.CardsDto;
import com.sagar.accounts.dto.CustomerDetailsDto;
import com.sagar.accounts.dto.LoansDto;
import com.sagar.accounts.entity.Accounts;
import com.sagar.accounts.entity.Customer;
import com.sagar.accounts.exception.ResourceNotFoundException;
import com.sagar.accounts.mapper.AccountsMapper;
import com.sagar.accounts.mapper.CustomerMapper;
import com.sagar.accounts.repository.AccountRepository;
import com.sagar.accounts.repository.CustomerRepository;
import com.sagar.accounts.service.ICustomersService;
import com.sagar.accounts.service.client.CardsFeignClient;
import com.sagar.accounts.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomersServiceImpl implements ICustomersService {

    private AccountRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", Long.toString(customer.getCustomerId()))
        );

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;

    }
}