package com.example.suhussai.as1;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.ListView;

import com.example.suhussai.as1.model.Entry;
import com.example.suhussai.as1.model.FuelLog;
import com.example.suhussai.as1.model.FuelUsageEntry;
import com.example.suhussai.as1.model.Log;

/**
 * Created by suhussai on 29/01/16.
 */
public class LogTest extends ActivityInstrumentationTestCase2 {
    public LogTest() {
        super(Log.class);
    }

    public void testGetEntry(){
        Log log = new Log();
        Entry entry1 = new FuelUsageEntry();
        entry1.setDate("2016/11/11");
        log.addEntry(entry1);
        Entry entry2 = new FuelUsageEntry();
        entry2.setDate("2016/11/11");
        log.addEntry(entry2);

        Entry e1 = log.getEntry(entry1.getMessageID());
        assertTrue(e1 == entry1);

        Entry e2 = log.getEntry(entry2.getMessageID());
        assertTrue(e2 == entry2);

    }

    public void testAddEntry() throws Exception {
        Log log = new Log();
        Entry entry1 = new FuelUsageEntry();
        entry1.setDate("2016/11/11");
        log.addEntry(entry1);
        Entry entry2 = new FuelUsageEntry();
        entry2.setDate("2016/11/11");
        log.addEntry(entry2);

        assertTrue(log.has(entry1.getMessageID()));
        assertTrue(log.has(entry2.getMessageID()));
    }

    public void testHas() throws Exception {
        Log log = new Log();

        Entry entry1 = new FuelUsageEntry();
        entry1.setDate("2016/11/11");
        Entry entry2 = new FuelUsageEntry();
        entry2.setDate("2016/11/11");

        assertFalse(log.has(entry1.getMessageID()));
        assertFalse(log.has(entry2.getMessageID()));


        log.addEntry(entry2);
        log.addEntry(entry1);

        assertTrue(log.has(entry1.getMessageID()));
        assertTrue(log.has(entry2.getMessageID()));

    }

    public void testRemoveEntry() {
        Log log = new Log();
        Entry entry1 = new FuelUsageEntry();
        entry1.setDate("2016/11/11");
        log.addEntry(entry1);
        Entry entry2 = new FuelUsageEntry();
        entry2.setDate("2016/11/11");
        log.addEntry(entry2);

        assertTrue(log.has(entry1.getMessageID()));
        assertTrue(log.has(entry2.getMessageID()));

        log.removeEntry(entry2.getMessageID());

        assertFalse(log.has(entry1.getMessageID()));
        assertTrue(log.has(entry2.getMessageID()));

        log.removeEntry(entry2.getMessageID());

        assertFalse(log.has(entry1.getMessageID()));
        assertFalse(log.has(entry2.getMessageID()));


    }
}

