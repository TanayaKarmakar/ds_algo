package com.app.questions.stack;

import java.util.Stack;

public class MinStack {
	private Stack<Integer> stack;
	private Stack<Integer> minStack;

	public MinStack() {
		stack = new Stack<>();
		minStack = new Stack<>();
	}

	public void push(int num) {
		stack.push(num);
		if(minStack.isEmpty() || minStack.peek() >= num) {
			minStack.push(num);
		}
	}

	public void pop() {
		int item = stack.pop();
		if(minStack.peek() == item) {
			minStack.pop();
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return !minStack.isEmpty() ? minStack.peek(): Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		MinStack mStack = new MinStack();
		mStack.push(0);
		mStack.push(1);
		mStack.push(0);
		
		System.out.println(mStack.getMin());
		
		mStack.pop();
		
		System.out.println(mStack.top());
		System.out.println(mStack.getMin());

	}

}
