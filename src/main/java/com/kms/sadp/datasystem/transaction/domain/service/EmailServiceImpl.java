package com.kms.sadp.datasystem.transaction.domain.service;

import com.kms.sadp.datasystem.transaction.domain.entity.Email;
import com.kms.sadp.datasystem.transaction.domain.entity.Mailbox;
import com.kms.sadp.datasystem.transaction.domain.repository.EmailRepository;
import com.kms.sadp.datasystem.transaction.domain.repository.MailboxRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceImpl.class);
    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private MailboxRepository mailboxRepository;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void addEmail() throws InterruptedException {
        LOGGER.info("Start addEmail");
        Email email = new Email();
        email.setRecipientId(2L);
        email.setBody("Hello");
        email.setUnreadFlag(true);

        emailRepository.save(email);
        LOGGER.info("Saved email");
        Thread.sleep(5000);

        Mailbox mailbox = mailboxRepository.findById(1L).get();
        mailbox.setUnread(mailbox.getUnread() + 1);
        mailboxRepository.save(mailbox);
    }

    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public void getEmail() throws InterruptedException {
        Thread.sleep(3000L);
        List<Email> emails = emailRepository.findByRecipientId(2L);
        List<Mailbox> mailboxes = mailboxRepository.findByRecipientId(2L);

        Assert.isTrue(emails.size() == 1, "Inconsistent data");
        LOGGER.info("Number of emails = " + emails.size());
        Assert.isTrue(mailboxes.get(0).getUnread() == 10, "Inconsistent data");
        LOGGER.info("Number of unread = " + mailboxes.get(0).getUnread());
    }
}
