package com.app.queue;

import java.util.Iterator;

public class CircularQueueBoundedTest {

	public static void main(String[] args) {
		int maxCapacity = 10;
		CircularQueueBounded q = new CircularQueueBounded(maxCapacity);
		q.add(1);
		q.add(2);
		q.add(3);
		
		System.out.println(q.poll());
		System.out.println(q.poll());
		
		
		q.add(4);
		q.add(5);
		q.add(6);
		q.add(7);
		q.add(8);
		q.add(9);
		q.add(10);
		q.add(11);
		q.add(12);
		
		
		Iterator<Integer> itr = q.iterator();
		
		
		System.out.println("Queue Items");
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
