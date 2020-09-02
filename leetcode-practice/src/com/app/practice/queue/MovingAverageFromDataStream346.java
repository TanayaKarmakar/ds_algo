package com.app.practice.queue;

import java.util.LinkedList;
import java.util.Queue;

class MovingAverage {
	int maxCap;
	Queue<Integer> q;
	int currentSum;
	
	public MovingAverage(int maxCap) {
		this.maxCap = maxCap;
		this.q = new LinkedList<>();
		this.currentSum = 0;
	}
	
	public double next(int val) {
		if(q.size() < maxCap) {
			q.add(val);
			currentSum += val;
		} else {
			int deletedEl = q.poll();
			currentSum -= deletedEl;
			currentSum += val;
			q.add(val);
		}
		return currentSum / (double)q.size();
	}
}

public class MovingAverageFromDataStream346 {

	public static void main(String[] args) {
		MovingAverage obj = new MovingAverage(3);
		System.out.println(obj.next(1));
		System.out.println(obj.next(10));
		System.out.println(obj.next(3));
		System.out.println(obj.next(5));

	}

}
