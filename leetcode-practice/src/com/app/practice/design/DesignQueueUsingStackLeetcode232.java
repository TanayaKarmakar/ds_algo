package com.app.practice.design;

import java.util.Stack;

class MyQueue {
	Stack<Integer> stack1;
	Stack<Integer> stack2;

	/** Initialize your data structure here. */
	public MyQueue() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		
		stack1.push(x);
		
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		return stack2.pop();
	}

	/** Get the front element. */
	public int peek() {
		return stack2.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return stack2.isEmpty();
	}
}

public class DesignQueueUsingStackLeetcode232 {

	public static void main(String[] args) {
		MyQueue q = new MyQueue();
		q.push(1);
		q.push(2);
		
		System.out.println(q.peek());
		
		System.out.println(q.pop());
		
		System.out.println(q.empty());
	}

}
