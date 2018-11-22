package com.kms.sadp.datasystem.transaction.domain.entity;

import javax.persistence.*;

@Table(name = "emails")
@Entity
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "recipient_id")
    private Long recipientId;
    @Column(name = "body")
    private String body;
    @Column(name = "unread_flag")
    private Boolean unreadFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Boolean getUnreadFlag() {
        return unreadFlag;
    }

    public void setUnreadFlag(Boolean unreadFlag) {
        this.unreadFlag = unreadFlag;
    }
}
