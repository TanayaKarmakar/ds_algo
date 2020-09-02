package com.app.practice.queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class LogItem {
	String key;
	int timestamp;
	
	public LogItem(String key, int timestamp) {
		this.key = key;
		this.timestamp = timestamp;
	}
}

class Logger {
	private Map<String, LogItem> map;
	private Queue<LogItem> q;
	
	public Logger() {
		map = new HashMap<>();
		q = new LinkedList<>();
	}
	
	public boolean shouldPrintMessage(int timestamp, 
			String message) {
		if(q.isEmpty() || !map.containsKey(message)) {
			LogItem item = new LogItem(message, timestamp);
			map.put(message, item);
			q.add(item);
			return true;
		} else {
			LogItem item = map.get(message);
			if(timestamp - 10 >= item.timestamp) {
				LogItem newItem = new LogItem(item.key, timestamp);
				q.remove(item);
				map.put(message, newItem);
				q.add(newItem);
				return true;
			} else {
				return false;
			}
		}
	}
}

public class LoggerRateLimiterLeetcode359 {

	public static void main(String[] args) {
		Logger logger = new Logger();
		System.out.println(logger.shouldPrintMessage(1, "foo"));
		System.out.println(logger.shouldPrintMessage(2, "bar"));
		System.out.println(logger.shouldPrintMessage(3, "foo"));
		System.out.println(logger.shouldPrintMessage(8, "bar"));
		System.out.println(logger.shouldPrintMessage(10, "foo"));
		System.out.println(logger.shouldPrintMessage(11, "foo"));
	}

}
