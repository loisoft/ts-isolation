package com.kms.sadp.datasystem.transaction.domain.service;

import com.kms.sadp.datasystem.transaction.domain.repository.MailboxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailboxServiceImpl implements MailboxService {
    @Autowired
    private MailboxRepository mailboxRepository;
}
