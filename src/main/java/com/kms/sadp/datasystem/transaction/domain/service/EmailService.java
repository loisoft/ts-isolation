package com.kms.sadp.datasystem.transaction.domain.service;

public interface EmailService {
    void addEmail() throws InterruptedException;

    int countEmailsReadUncommitted(long recipientId);

    int countEmailsReadCommitted(long recipientId);
}
