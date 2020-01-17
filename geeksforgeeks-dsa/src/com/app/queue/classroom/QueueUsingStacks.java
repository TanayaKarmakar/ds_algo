package com.app.queue.classroom;

import java.util.Stack;

//here we will make add operation costly
public class QueueUsingStacks {
	private Stack<Integer> s1 = new Stack<>();
	private Stack<Integer> s2 = new Stack<>();
	
	public void add(int data) {
		while(!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		s1.push(data);
		
		while(!s2.isEmpty()) {
			s1.add(s2.pop());
		}
	}
	
	public int remove() {
		if(s1.isEmpty())
			return -1;
		return s1.pop();
	}
	
	public int peek() {
		if(s1.isEmpty())
			return -1;
		return s1.peek();
	}
	
	public int size() {
		return s1.size();
	}

	public static void main(String[] args) {
		QueueUsingStacks qs = new QueueUsingStacks();
		qs.add(1);
		qs.add(2);
		qs.add(3);
		qs.add(4);
		qs.add(5);

		System.out.println("Remove item - " + qs.remove());
		System.out.println("Remove item - " + qs.remove());
		System.out.println("Size of the queue - " + qs.size());
		System.out.println("Front Item of the queue - " + qs.peek());
	}

}
