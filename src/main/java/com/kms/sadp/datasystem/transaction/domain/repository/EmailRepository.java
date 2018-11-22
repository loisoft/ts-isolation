package com.kms.sadp.datasystem.transaction.domain.repository;

import com.kms.sadp.datasystem.transaction.domain.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
    List<Email> findByRecipientId(long recipientId);
}
