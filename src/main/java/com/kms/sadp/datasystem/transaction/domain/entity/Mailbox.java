package com.kms.sadp.datasystem.transaction.domain.entity;

import javax.persistence.*;

@Table(name = "mailboxes")
@Entity
public class Mailbox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "unread")
    private Long unread;
    @Column(name = "recipient_id")
    private Long recipientId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUnread() {
        return unread;
    }

    public void setUnread(Long unread) {
        this.unread = unread;
    }

    public Long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }
}
