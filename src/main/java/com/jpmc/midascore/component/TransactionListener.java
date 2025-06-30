package com.jpmc.midascore.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionListener {

    @Autowired
    private DatabaseConduit databaseConduit;

    @KafkaListener(topics = "transactions", groupId = "group_id")
    public void listen(String message) {
        // Example: incoming message format = "1,2,100.0"
        String[] parts = message.split(",");
        Long senderId = Long.parseLong(parts[0]);
        Long recipientId = Long.parseLong(parts[1]);
        Double amount = Double.parseDouble(parts[2]);

        databaseConduit.processTransaction(senderId, recipientId, amount);
    }
}
