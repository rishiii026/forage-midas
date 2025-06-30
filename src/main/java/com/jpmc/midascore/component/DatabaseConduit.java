package com.jpmc.midascore.component;

import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.repository.UserRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Component
public class DatabaseConduit {

     @Autowired
    private RestTemplate restTemplate;

   
    @Autowired
    private UserRecordRepository userRecordRepository;

    @Transactional
    public void saveUser(UserRecord user) {
        userRecordRepository.save(user);
    }

    @Transactional
    public void processTransaction(Long senderId, Long recipientId, Double amount) {
        UserRecord sender = userRecordRepository.findById(senderId).orElse(null);
        UserRecord recipient = userRecordRepository.findById(recipientId).orElse(null);

        if (sender != null) {
            sender.setBalance(sender.getBalance() - amount);
            userRecordRepository.save(sender);
        }
        if (recipient != null) {
            recipient.setBalance(recipient.getBalance() + amount);
            userRecordRepository.save(recipient);
        }

        System.out.println("Processed: " + senderId + " → " + recipientId + " : $" + amount);
    }
}