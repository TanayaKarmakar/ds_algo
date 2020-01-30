package com.app.heap.classroom;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueue<Integer> pQueue = new PriorityQueue<>();

		int[] nums = { 5, 3, 17, 10, 84, 19, 6, 22, 9 };
		for (Integer el : nums) {
			pQueue.add(el);
		}

		System.out.println("Displaying elements of priority queue");
		Iterator<Integer> qItr = pQueue.iterator();

		while (qItr.hasNext()) {
			System.out.print(qItr.next() + " ");
		}

		System.out.println();

	}

}
