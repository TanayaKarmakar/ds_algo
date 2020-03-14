package com.app.questions;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
	private PriorityQueue<Integer> maxHeap;
	private PriorityQueue<Integer> minHeap;
	
	public MedianFinder() {
		maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		minHeap = new PriorityQueue<>();
	}
	
	public void addNum(int num) {
		if(maxHeap.isEmpty())
			maxHeap.add(num);
		else if(!minHeap.isEmpty() && maxHeap.size() == minHeap.size()) {
			if(minHeap.peek() < num) {
				maxHeap.add(minHeap.poll());
				minHeap.add(num);
			} else {
				maxHeap.add(num);
			}
		} else {
			if(maxHeap.peek() > num) {
				//maxHeap.add(num);
				minHeap.add(maxHeap.poll());
				maxHeap.add(num);
			} else {
				minHeap.add(num);
			}
		}
	}
	
	public double findMedian() {
		if((!maxHeap.isEmpty() && !minHeap.isEmpty()) 
				&& (maxHeap.size() == minHeap.size()))
			return (maxHeap.peek() + minHeap.peek()) / 2.0;
		else
			return maxHeap.peek();
	}

	public static void main(String[] args) {
		MedianFinder obj = new MedianFinder();
		obj.addNum(-1);
		System.out.println(obj.findMedian());
		obj.addNum(-2);
		System.out.println(obj.findMedian());
		obj.addNum(-3);
		System.out.println(obj.findMedian());
		

	}

}
