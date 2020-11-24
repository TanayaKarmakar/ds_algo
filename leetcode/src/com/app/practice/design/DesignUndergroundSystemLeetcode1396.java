package com.app.practice.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TravelItem {
	String stationName;
	int timeStamp;
	
	public TravelItem(String stationName, int timeStamp) {
		this.stationName = stationName;
		this.timeStamp = timeStamp;
	}
}

class TravelTimeItem {
	int startTime;
	int endTime;
	
	public TravelTimeItem(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
}


class UndergroundSystem {
	Map<Integer, TravelItem> travelMap;
	Map<String, List<TravelTimeItem>> travelTimeMap;

    public UndergroundSystem() {
        travelMap = new HashMap<>();
        travelTimeMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        travelMap.put(id, new TravelItem(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        TravelItem tItem = travelMap.get(id);
        String path = tItem.stationName + "-" + stationName;
        if(!travelTimeMap.containsKey(path))
        	travelTimeMap.put(path, new ArrayList<>());
        travelTimeMap.get(path).add(new TravelTimeItem(tItem.timeStamp, t));
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "-" + endStation;
        if(!travelTimeMap.containsKey(key))
        	return 0;
        List<TravelTimeItem> items = travelTimeMap.get(key);
        double total = items.size();
        double sum = 0;
        for(TravelTimeItem tItem: items) {
        	sum += (tItem.endTime - tItem.startTime);
        }
        
        return sum / total;
        
    }
}

public class DesignUndergroundSystemLeetcode1396 {

	public static void main(String[] args) {
		UndergroundSystem undergroundSystem = new UndergroundSystem();
		undergroundSystem.checkIn(45, "Leyton", 3);
		undergroundSystem.checkIn(32, "Paradise", 8);
		undergroundSystem.checkIn(27, "Leyton", 10);
		undergroundSystem.checkOut(45, "Waterloo", 15);
		undergroundSystem.checkOut(27, "Waterloo", 20);
		undergroundSystem.checkOut(32, "Cambridge", 22);
		
		System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge"));
		
		undergroundSystem.getAverageTime("Leyton", "Waterloo");  
		
		System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
		
		undergroundSystem.checkIn(10, "Leyton", 24);
		
		System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
		
		undergroundSystem.checkOut(10, "Waterloo", 38);
		
		System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
				
		

	}

}
