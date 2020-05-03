package com.app.mock.google.set1;

import java.util.HashMap;
import java.util.Map;

public class MyCalendarTwo {
	Map<Integer, Integer> startBook;
	public MyCalendarTwo() {
		startBook = new HashMap<>();
	}
	
	public boolean book(int start, int end) {
		if(hasDoubleBooking(start, end))
			return true;
		for(int i = start; i < end; i++) {
			startBook.put(i, startBook.getOrDefault(i, 0) + 1);
		}
		return true;
	}
	
	private boolean hasDoubleBooking(int start, int end) {
		if(start > end)
			return true;
		int mid = start + (end - start)/2;
		if(startBook.containsKey(mid) && startBook.get(mid) == 2)
			return false;
		return hasDoubleBooking(start, mid - 1) && hasDoubleBooking(mid + 1, end);
	}

	public static void main(String[] args) {
		MyCalendarTwo obj = new MyCalendarTwo();
		System.out.println(obj.book(10, 20));
		System.out.println(obj.book(50, 60));
		System.out.println(obj.book(10, 40));
		System.out.println(obj.book(5, 15));
		System.out.println(obj.book(5, 10));
		System.out.println(obj.book(25, 55));

	}

}
