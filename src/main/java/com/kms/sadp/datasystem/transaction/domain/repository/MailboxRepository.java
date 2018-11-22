package com.kms.sadp.datasystem.transaction.domain.repository;

import com.kms.sadp.datasystem.transaction.domain.entity.Mailbox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MailboxRepository extends JpaRepository<Mailbox, Long> {
    List<Mailbox> findByRecipientId(long recipientId);
}
