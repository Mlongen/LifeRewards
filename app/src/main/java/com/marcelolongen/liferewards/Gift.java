package com.marcelolongen.liferewards;

import java.util.Date;

public class Gift {

    private String sender;
    private String description;
    private int amount;
    private Date sentDate;
    private String status;

    public Gift(String sender, String description, int amount, Date sentDate) {
        this.sender = sender;
        this.description = description;
        this.amount = amount;
        this.sentDate = new Date();
        this.status = "unopened";
    }

    public String getSender() {
        return sender;
    }


    public String getDescription() {
        return description;
    }

    public int getAmount() {
        return amount;
    }


    public Date getSentDate() {
        return sentDate;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
