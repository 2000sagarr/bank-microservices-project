package com.sagar.accounts.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Customer extends BaseEntity{
//  `customer_id` int AUTO_INCREMENT  PRIMARY KEY,
//  `name` varchar(100) NOT NULL,
//  `email` varchar(100) NOT NULL,
//  `mobile_number` varchar(20) NOT NULL,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;

    private String name;
    private String email;
    private String mobileNumber;

}
