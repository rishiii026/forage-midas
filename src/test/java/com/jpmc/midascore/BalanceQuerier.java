package com.jpmc.midascore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.jpmc.midascore.foundation.Balance;

public class BalanceQuerier {
 @Autowired
    private RestTemplate restTemplate;

    public Balance query(Long userId) {
        return restTemplate.getForObject(
            "http://localhost:33400/balance?userId=" + userId,
            Balance.class
        );
    }
}

