package com.shareholder.abay.finapps.finappsproject.model;

import java.util.Date;

/**
 * Created by abay on 10/24/16.
 */
public class Message {
    private String theme;
    private String receiver;
    private Date date;

    public Message(String theme, String receiver, Date date) {
        this.theme = theme;
        this.receiver = receiver;
        this.date = date;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
