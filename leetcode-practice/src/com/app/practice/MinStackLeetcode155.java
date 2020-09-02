package com.app.practice;

import java.util.Stack;

class MinStack {
	private Stack<Integer> stack;
	private Stack<Integer> minStack;
	
	public MinStack() {
		stack = new Stack<>();
		minStack = new Stack<>();
	}
	
	public void push(int num) {
		stack.push(num);
		if(minStack.isEmpty() || minStack.peek() >= num)
			minStack.push(num);
	}
	
	public int pop() {
		int poppedEl = stack.pop();
		if(minStack.peek() == poppedEl) {
			minStack.pop();
		}
		return poppedEl;
	}
	
	public int top() {
		if(!stack.isEmpty())
			return stack.peek();
		return Integer.MAX_VALUE;
	}
	
	public int getMin() {
		if(!minStack.isEmpty())
			return minStack.peek();
		return Integer.MAX_VALUE;
	}
}

public class MinStackLeetcode155 {

	public static void main(String[] args) {
		MinStack mStack = new MinStack();
		mStack.push(-2);
		mStack.push(0);
		mStack.push(-3);
		
		System.out.println("Minimum Element - " + mStack.getMin());
		System.out.println("Pop - " + mStack.pop());
		System.out.println("Top - " + mStack.top());
		System.out.println("Minimum Element - " + mStack.getMin());
	}

}
