package com.app.queue.classroom;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class ReversingQueue {
	private static void reversingQueue(Queue<Integer> queue) {
		if(queue.isEmpty())
			return;
		int x = queue.remove();
		reversingQueue(queue);
		queue.add(x);
	}
	
	private static void display(Queue<Integer> queue) {
		Iterator<Integer> qItr = queue.iterator();
		while(qItr.hasNext()) {
			System.out.print(qItr.next() + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		reversingQueue(queue);
		display(queue);
	}

}
