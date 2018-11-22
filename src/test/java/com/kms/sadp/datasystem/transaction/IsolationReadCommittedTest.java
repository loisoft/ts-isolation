package com.kms.sadp.datasystem.transaction;

import com.kms.sadp.datasystem.transaction.domain.service.EmailService;
import com.kms.sadp.datasystem.transaction.domain.service.MailboxService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
@Sql(executionPhase=Sql.ExecutionPhase.BEFORE_TEST_METHOD,scripts="classpath:/data-mysql.sql")
public class IsolationReadCommittedTest {
    @Autowired
    private EmailService emailService;

    @Autowired
    private MailboxService mailboxService;

    @Test
    public void shouldReadCommittedOk() throws InterruptedException {
        Runnable runnable1 = () -> {
            try {
                //create new email and increase unread number to 11
                emailService.addEmail();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable runnable2 = () -> {
            try {
                Thread.sleep(2000L);
                int count = emailService.countEmailsReadCommitted(2L);
                Assert.assertEquals(0, count);
                int countUnread = mailboxService.getUnread(2L);
                Assert.assertEquals(10, countUnread);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(runnable1).start();
        new Thread(runnable2).start();

        Thread.sleep(5000L);
    }
}
