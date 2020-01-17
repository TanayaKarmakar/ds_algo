package com.app.queue.classroom;

import java.util.LinkedList;
import java.util.Queue;

//here we are going to make pop operation costly
public class StackUsingQueue2 {
	private Queue<Integer> q1 = new LinkedList<>();
	private Queue<Integer> q2 = new LinkedList<>();
	
	public void push(int data) {
		q1.add(data);
	}
	
	public int pop() {
		if(q1.isEmpty())
			return -1;
		if(q1.size() == 1)
			return q1.remove();
		
		while(q1.size() != 1) {
			q2.add(q1.remove());
		}
		
		int el = q1.remove();
		
		Queue<Integer> q = q1;
		q1 = q2;
		q2 = q;
		
		return el;
	}	

	public static void main(String[] args) {
		StackUsingQueue2 sq = new StackUsingQueue2();
		sq.push(1);
		sq.push(2);
		sq.push(3);
		sq.push(4);
		sq.push(5);
		sq.push(6);
		
		System.out.println("Pop - " + sq.pop());
		System.out.println("Pop - " + sq.pop());
	}
}
