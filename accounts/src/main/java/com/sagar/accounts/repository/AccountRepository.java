package com.sagar.accounts.repository;

import com.sagar.accounts.entity.Accounts;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public interface AccountRepository extends JpaRepository<Accounts, Long> {
    Optional<Accounts> findByCustomerId(Long aLong);

    @Transactional
    @Modifying
    void deleteByCustomerId(Long customerId);
}
