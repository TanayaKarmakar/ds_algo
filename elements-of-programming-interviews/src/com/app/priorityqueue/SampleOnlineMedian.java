package com.app.priorityqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class SampleOnlineMedian {
	private static List<Double> sampleOnlineMedian(List<Integer> numbers) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		List<Double> result = new ArrayList<>();
		Iterator<Integer> nItr = numbers.iterator();

		while (nItr.hasNext()) {
			Integer num = nItr.next();

			minHeap.add(num);
			maxHeap.add(minHeap.remove());

			if (maxHeap.size() > minHeap.size()) {
				minHeap.add(maxHeap.remove());
			}

			result.add(minHeap.size() == maxHeap.size() ? 0.5 * (maxHeap.peek() + minHeap.peek()) : minHeap.peek());
		}

		return result;
	}

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 0, 3, 5, 2, 0, 1);
		List<Double> result = sampleOnlineMedian(numbers);
		
		System.out.println(result);
	}

}
