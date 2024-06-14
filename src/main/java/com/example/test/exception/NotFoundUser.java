package com.example.test.exception;

import java.util.Date;


public class NotFoundUser {
    private Date timestamp;
    private String content;
    private int status;

    public NotFoundUser(Date timestamp, String content, int status) {
        this.timestamp = timestamp;
        this.content = content;
        this.status = status;
    }

    public NotFoundUser() {
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
