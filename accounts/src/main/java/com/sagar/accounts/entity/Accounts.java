package com.sagar.accounts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Setter @Getter @ToString @NoArgsConstructor @AllArgsConstructor
public class Accounts extends BaseEntity{
//  `customer_id` int NOT NULL,
//  `account_number` int AUTO_INCREMENT  PRIMARY KEY,
//  `account_type` varchar(100) NOT NULL,
//  `branch_address` varchar(200) NOT NULL

    private long customerId;

    @Id
    private long accountNumber;
    private String accountType;
    private String branchAddress;

}
