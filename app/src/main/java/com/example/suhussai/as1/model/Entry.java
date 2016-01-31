package com.example.suhussai.as1.model;

import java.util.Date;

/**
 * Created by suhussai on 25/01/16.
 */
public abstract class Entry {
    protected int messageID;
    protected String date="";
    public abstract int getMessageID();
    protected abstract void setMessageID();

    public String getDate() {
        return this.date;
    }
    public void setDate(String date){
        this.messageID -= date.hashCode();
        this.date = date;
        this.messageID += date.hashCode();
    }

    public abstract String toString();
}
