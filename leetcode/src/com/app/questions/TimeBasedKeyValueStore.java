package com.app.questions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class TimeValue {
	String value;
	int timeStamp;
	
	public TimeValue(String value, int timeStamp) {
		this.value = value;
		this.timeStamp = timeStamp;
	}
}

public class TimeBasedKeyValueStore {
	private Map<String, List<TimeValue>> timeMap = new LinkedHashMap<>();
	

	public void set(String key, String value, int timeStamp) {
		if(!timeMap.containsKey(key)) {
			List<TimeValue> list = new ArrayList<>();
			list.add(new TimeValue(value, timeStamp));
			timeMap.put(key, list);
		} else {
			timeMap.get(key).add(new TimeValue(value, timeStamp));
		}
	}
	
	public String get(String key, int timeStamp) {
		List<TimeValue> timeValues = timeMap.get(key);
		return getClosest(timeValues, timeStamp, 0, timeValues.size() - 1);
	}
	
	private String getClosest(List<TimeValue> timeValues, int timeStamp, int low, int high) {
		if(low > high)
			return "";
		TimeValue val = timeValues.get(high);
		if(timeStamp >= val.timeStamp)
			return val.value;
		
		int mid = (low + high)/2;
		val = timeValues.get(mid);
		if(val.timeStamp == timeStamp)
			return val.value;
		
		if(mid > 0 && timeStamp >= timeValues.get(mid - 1).timeStamp && timeStamp < val.timeStamp)
			return timeValues.get(mid - 1).value;
		
		if(timeStamp < val.timeStamp)
			return getClosest(timeValues, timeStamp, low, mid - 1);
		return getClosest(timeValues, timeStamp, mid + 1, high);
	}
	
	public static void main(String[] args) {
		//TC1
		TimeBasedKeyValueStore obj = new TimeBasedKeyValueStore();
		obj.set("foo", "bar", 1);
		
		System.out.println(obj.get("foo", 1));
		System.out.println(obj.get("foo", 3));
		
		obj.set("foo", "bar2", 4);
		
		System.out.println(obj.get("foo", 4));
		System.out.println(obj.get("foo", 5));

	}

}
