package com.app.queue.classroom;

import java.util.LinkedList;
import java.util.Queue;

//here we are making push operation costly
public class StackUsingQueue1 {
	private Queue<Integer> q1 = new LinkedList<>();
	private Queue<Integer> q2 = new LinkedList<>();
	
	public void push(int data) {
		q2.add(data);
		
		while(!q1.isEmpty()) {
			q2.add(q1.remove());
		}
		
		Queue<Integer> q = q1;
		q1 = q2;
		q2 = q;	
	}
	
	public int pop() {
		if(q1.isEmpty())
			return -1;
		return q1.remove();
	}
	
	public int peek() {
		if(q1.isEmpty())
			return -1;
		return q1.peek();
	}

	public static void main(String[] args) {
		StackUsingQueue1 sq = new StackUsingQueue1();
		sq.push(1);
		sq.push(2);
		sq.push(3);
		sq.push(4);
		sq.push(5);

		System.out.println(sq.pop());
		System.out.println(sq.pop());
	}

}
