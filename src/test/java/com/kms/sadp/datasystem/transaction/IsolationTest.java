package com.kms.sadp.datasystem.transaction;

import com.kms.sadp.datasystem.transaction.domain.service.EmailService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Sql(executionPhase=Sql.ExecutionPhase.BEFORE_TEST_METHOD,scripts="classpath:/data-mysql.sql")
public class IsolationTest {
    @Autowired
    private EmailService emailService;

    @Test
    public void shouldReadUncommitted() throws InterruptedException {
        Runnable runnable1 = () -> {
            try {
                emailService.addEmail();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable runnable2 = () -> {
            try {
                emailService.getEmail();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(runnable1).start();
        new Thread(runnable2).start();

        Thread.sleep(10000L);

        new Thread(runnable2).start();

        Thread.sleep(7000L);
    }
}
