package com.jpmc.midascore;

import com.jpmc.midascore.component.DatabaseConduit;
import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.foundation.Balance;
import com.jpmc.midascore.foundation.FileLoader;
import com.jpmc.midascore.repository.UserRecordRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TaskFiveTests {

    static final Logger logger = LoggerFactory.getLogger(TaskFiveTests.class);

    @Autowired
    private DatabaseConduit databaseConduit;

    @Autowired
    private UserRecordRepository userRecordRepository;

    @Autowired
    private FileLoader fileLoader;

    @Autowired
    private BalanceQuerier balanceQuerier;

    @Test
    void task_five_verifier() throws InterruptedException {
        // Populate test user
        for (long i = 0; i < 13; i++) {
            if (!userRecordRepository.findById(i).isPresent()) {
                UserRecord user = new UserRecord();
                user.setId(i);
                user.setName("user" + i);
                user.setBalance(1000.0);
                userRecordRepository.save(user);
            }
        }

        // Load transactions & process directly (NO Kafka)
        List<String> transactionLines = fileLoader.loadStrings("transactions.txt");
        for (String transactionLine : transactionLines) {
            String[] parts = transactionLine.split(",");
            Long senderId = Long.parseLong(parts[0].trim());
            Long recipientId = Long.parseLong(parts[1].trim());
            Double amount = Double.parseDouble(parts[2].trim());
            databaseConduit.processTransaction(senderId, recipientId, amount);
        }

        Thread.sleep(2000);

        logger.info("----------------------------------------------------------");
        logger.info("---begin output ---");
        for (int i = 0; i < 13; i++) {
            Balance balance = balanceQuerier.query((long) i);
            logger.info(balance.toString());
        }
        logger.info("---end output ---");
    }
}
