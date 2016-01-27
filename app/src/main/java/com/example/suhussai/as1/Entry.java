package com.example.suhussai.as1;

import java.util.Date;

/**
 * Created by suhussai on 25/01/16.
 */
public abstract class Entry {
    protected int messageID;
    protected Date date;
    public abstract int getMessageID();
    public abstract Date getDate();

    protected abstract void setMessageID();

    public abstract void setDate(Date date);
    public abstract String toString();
}
