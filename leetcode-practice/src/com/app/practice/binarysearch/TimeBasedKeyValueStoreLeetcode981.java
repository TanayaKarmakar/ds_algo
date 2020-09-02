package com.app.practice.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Item {
	int timeStamp;
	String key;
	String value;
	
	public Item(int timeStamp, String key, String value) {
		this.timeStamp = timeStamp;
		this.key = key;
		this.value = value;
	}
}

class TimeMap {
	Map<String, List<Item>> map;

    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
        	map.put(key, new ArrayList<>());
        }
        Item item = new Item(timestamp, key, value);
        map.get(key).add(item);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
        	return "";
        List<Item> items = map.get(key);
        int n = items.size();
        int low = 0;
        int high = n - 1;
        int floor = -1;
        while(low <= high) {
        	int mid = low + (high - low) /2 ;
        	Item item = items.get(mid);
        	if(item.timeStamp == timestamp)
        		return item.value;
        	else if(item.timeStamp > timestamp)
        		high = mid - 1;
        	else {
        		floor = low;
        		low = mid + 1;
        	}
        		
        }
        if(floor == -1)
        	return "";
        return items.get(floor).value;
    }
}


public class TimeBasedKeyValueStoreLeetcode981 {

	public static void main(String[] args) {
		TimeMap obj = new TimeMap();
		obj.set("foo", "bar", 1);
		
		System.out.println(obj.get("foo", 1));
		System.out.println(obj.get("foo", 3));

	}

}
