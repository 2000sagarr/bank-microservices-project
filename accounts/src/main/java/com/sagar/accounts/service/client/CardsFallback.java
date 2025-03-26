package com.sagar.accounts.service.client;

import com.sagar.accounts.dto.CardsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CardsFallback implements CardsFeignClient{
    @Override
    public ResponseEntity<CardsDto> fetchCardDetails(String correaltionId, String mobileNumber) {
//        if any issue occur in cards microservices instead of exception return some data;
        return null;
    }
}
