package com.jpmc.midascore.controller;

import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.foundation.Balance;
import com.jpmc.midascore.repository.UserRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BalanceController {

    @Autowired
    private UserRecordRepository userRecordRepository;

    @GetMapping("/balance")
    public Balance getBalance(@RequestParam Long userId) {
        UserRecord user = userRecordRepository.findById(userId).orElse(null);
        float amount = 0.0f;
        if (user != null && user.getBalance() != null) {
            amount = user.getBalance().floatValue();
        }
        return new Balance(amount);
    }
}

