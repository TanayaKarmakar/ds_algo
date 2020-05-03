package com.app.questions.practice;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
	private PriorityQueue<Integer> maxHeap;
	private PriorityQueue<Integer> minHeap;
	
	public MedianFinder() {
		maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		minHeap = new PriorityQueue<Integer>();
	}
	
	public void addNumber(int num) {
		if(maxHeap.size() > minHeap.size()) {
			if(maxHeap.peek() > num) {
				minHeap.add(maxHeap.poll());
				maxHeap.add(num);
			} else {
				minHeap.add(num);
			}
		} else {
			if(maxHeap.isEmpty() || maxHeap.peek() >= num) {
				maxHeap.add(num);
			} else {
				minHeap.add(num);
				maxHeap.add(minHeap.poll());
			}
		}
	}
	
	public double findMedian() {
		if(!maxHeap.isEmpty()) {
			if(maxHeap.size() == minHeap.size())
				return (maxHeap.peek() + minHeap.peek())/2.0;
			else 
				return maxHeap.peek();
		} else {
			return 0;
		}
	}
}

public class MedianOfAStreamLeetcode295 {

	public static void main(String[] args) {
		MedianFinder mf = new MedianFinder();
		mf.addNumber(12);
		mf.addNumber(15);
		System.out.println(mf.findMedian());
//		mf.addNumber(1);
//		mf.addNumber(2);
//		
//		System.out.println(mf.findMedian());
//		
//		mf.addNumber(3);
//		
//		System.out.println(mf.findMedian());
	}

}
