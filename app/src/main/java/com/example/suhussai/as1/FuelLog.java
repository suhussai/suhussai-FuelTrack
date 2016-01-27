package com.example.suhussai.as1;

import java.util.ArrayList;

/**
 * Created by suhussai on 26/01/16.
 */
public class FuelLog extends Log<FuelUsageEntry>{


    public FuelLog() {
        super();
    }

/*  // methods we've inherited already
    public void setLogs(ArrayList<FuelUsageEntry> logs){
        this.logs = logs;
    }
    public void addEntry(FuelUsageEntry fuelUsageEntry){
        this.logs.add(fuelUsageEntry);
    }

    public void removeEntry(int messageID){
        for (Entry e: this.logs){
            if (e.getMessageID() == messageID){
                this.logs.remove(e);
            }
        }
    }
*/
    public float getTotalFuelCost() {
        float total = 0;
        for (FuelUsageEntry e: this.logs){
            total += e.getFuelCost();
        }
        return total;
    }

}
