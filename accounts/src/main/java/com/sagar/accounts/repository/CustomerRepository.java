package com.sagar.accounts.repository;

import com.sagar.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    public Optional<Customer> findByMobileNumber(String mobileNumber);

}
