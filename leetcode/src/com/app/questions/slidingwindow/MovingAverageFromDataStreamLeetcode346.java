package com.app.questions.slidingwindow;

import java.util.LinkedList;
import java.util.Queue;

class MovingAverage {
	private int right;
	private int current;
	private Queue<Integer> q;
	private int currentSum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        right = size;
        current = 0;
        currentSum = 0;
        q = new LinkedList<>();
    }
    
    public double next(int val) {
        if(current < right) {
        	q.add(val);
        	currentSum += val;
        	current++;
        } else {
        	currentSum -= q.poll();
        	q.add(val);
        	currentSum += val;
        }
        return (currentSum / (double)q.size());
    }
}

public class MovingAverageFromDataStreamLeetcode346 {

	public static void main(String[] args) {
		MovingAverage obj = new MovingAverage(3);
		System.out.println(obj.next(1));
		System.out.println(obj.next(10));
		System.out.println(obj.next(3));
		System.out.println(obj.next(5));

	}

}
