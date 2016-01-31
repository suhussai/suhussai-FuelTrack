package com.example.suhussai.as1.model;

import android.content.Context;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.Iterator;

import com.example.suhussai.as1.model.Entry;

/**
 * Created by suhussai on 25/01/16.
 * ref:
 * http://stackoverflow.com/questions/28242386/cannot-resolve-method-openfileoutputjava-lang-string-int
 */
public class Log <T extends Entry> {

    protected ArrayList<T> logs;
    public Log() {
        this.logs = new ArrayList<>();
    }

    public ArrayList<T> getLogs() {
        return logs;
    }
    public void setLogs(ArrayList<T> logs){
        this.logs = logs;
    }
    public void setEntry(int messageID, T newT) {
        T itemToChange = getEntry(messageID);
        itemToChange.setDate(newT.getDate());
    }

    public T getEntry(int messageID) {
        Iterator<T> iter = logs.iterator();
        while (iter.hasNext()) {
            T t2 = iter.next();

            if (t2.getMessageID() == messageID) {
                return t2;
            }
        }
        return null;
    }
    public void addEntry(T t){
        this.logs.add(t);
    }
    public boolean has(int messageID) {
        boolean logHasValue = false;
        Iterator<T> iter = logs.iterator();

        while (iter.hasNext()) {
            T t1 = iter.next();

            if (t1.getMessageID() == messageID) {
                logHasValue = true;
                //iter.remove();
            }
        }
        return logHasValue;
    }
    public void removeEntry(int messageID){

        Iterator<T> iter = logs.iterator();
        T itemToRemove = null;
        while (iter.hasNext()) {
            T t3 = iter.next();

            if (t3.getMessageID() == messageID) {
                itemToRemove = t3;
                //iter.remove();
            }
        }
        if (itemToRemove != null) {
            logs.remove(itemToRemove);
        }

    }

}
