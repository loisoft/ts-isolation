package com.kms.sadp.datasystem.transaction.domain.service;

import com.kms.sadp.datasystem.transaction.domain.repository.MailboxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MailboxServiceImpl implements MailboxService {
    @Autowired
    private MailboxRepository mailboxRepository;

    @Override
    @Transactional
    public int getUnread(long recipientId) {
        return mailboxRepository.findByRecipientId(recipientId).get(0).getUnread();
    }
}
