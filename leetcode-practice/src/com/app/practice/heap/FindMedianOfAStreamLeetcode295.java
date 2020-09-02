package com.app.practice.heap;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
	private PriorityQueue<Integer> maxHeap;
	private PriorityQueue<Integer> minHeap;
	
	public MedianFinder() {
		maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		minHeap = new PriorityQueue<>();
	}
	
	public void addNum(int num) {
		if(maxHeap.size() == minHeap.size()) {
			if(maxHeap.isEmpty() || maxHeap.peek() >= num) {
				maxHeap.add(num);
			} else {
				minHeap.add(num);
				maxHeap.add(minHeap.poll());
			}
		} else {
			if(maxHeap.peek() > num) {
				minHeap.add(maxHeap.poll());
				maxHeap.add(num);
			} else {
				minHeap.add(num);
			}
		}
	}
	
	public double findMedian() {
		if(minHeap.size() == maxHeap.size()) {
			if(!minHeap.isEmpty() && !maxHeap.isEmpty())
				return (minHeap.peek() + maxHeap.peek()) / 2.0;
			else 
				return 0;
		} else {
			return maxHeap.peek();
		}
	}
}

public class FindMedianOfAStreamLeetcode295 {

	public static void main(String[] args) {
		MedianFinder mf = new MedianFinder();
		mf.addNum(12);
		
		System.out.println(mf.findMedian());
		
		mf.addNum(15);
		
		System.out.println(mf.findMedian());
		
		mf.addNum(10);
		
		System.out.println(mf.findMedian());
		
		mf.addNum(5);
		
		System.out.println(mf.findMedian());
		
		mf.addNum(8);
		
		System.out.println(mf.findMedian());

	}

}
