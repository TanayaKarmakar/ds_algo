package com.app.practice;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
	private PriorityQueue<Integer> maxHeap;
	private PriorityQueue<Integer> minHeap;

	public MedianFinder() {
		maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		minHeap = new PriorityQueue<Integer>();
	}

	public void addNum(int num) {
		if (maxHeap.size() == minHeap.size()) {
			if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
				maxHeap.add(num);
			} else {
				maxHeap.add(num);
				minHeap.add(maxHeap.poll());
			}
		} else {
			if (maxHeap.peek() > num) {
				minHeap.add(maxHeap.poll());
				maxHeap.add(num);
			} else {
				minHeap.add(num);
			}
		}
	}

	public double findMedian() {
		if (maxHeap.isEmpty() && minHeap.isEmpty())
			return 0;
		else if (maxHeap.size() == minHeap.size())
			return ((maxHeap.peek() + minHeap.peek()) / 2.0);
		else
			return maxHeap.peek();
	}
}

public class MedianOfAStreamLeetcode295 {

	public static void main(String[] args) {
		MedianFinder mf = new MedianFinder();
		int[] nums = { 12, 15, 10, 5, 8, 7, 16 };

		for (int num : nums) {
			mf.addNum(num);

			System.out.println(mf.findMedian());
		}

	}

}
