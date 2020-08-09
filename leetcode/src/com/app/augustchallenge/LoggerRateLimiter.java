package com.app.augustchallenge;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class LogItem {
	int timeStamp;
	String key;
	
	public LogItem(int timeStamp, String key) {
		this.timeStamp = timeStamp;
		this.key = key;
	}
}

class Logger {
	Queue<LogItem> queue;
	Map<String, LogItem> map;

    /** Initialize your data structure here. */
    public Logger() {
        queue = new LinkedList<>();
        map = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(queue.isEmpty() || !map.containsKey(message)) {
        	LogItem item = new LogItem(timestamp, message);
        	queue.add(item);
        	map.put(message, item);
        	return true;
        } else {
        	LogItem item = map.get(message);
        	if(timestamp - 10 >= item.timeStamp) {
        		queue.remove(item);
        		LogItem newItem = new LogItem(timestamp, message);
        		map.put(message, newItem);
        		queue.add(newItem);
        		return true;
        	} else {
        		return false;
        	}
        }
    }
}


public class LoggerRateLimiter {

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
