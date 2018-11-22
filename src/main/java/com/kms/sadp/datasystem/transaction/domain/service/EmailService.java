package com.kms.sadp.datasystem.transaction.domain.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

public interface EmailService {
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    void addEmail() throws InterruptedException;
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    void getEmail() throws InterruptedException;
}
