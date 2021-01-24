package com.app.practice.stack;

import java.util.Stack;

class MinStack {
	Stack<Integer> stack;
	Stack<Integer> minStack;

	/** initialize your data structure here. */
	public MinStack() {
		stack = new Stack<>();
		minStack = new Stack<>();
	}

	public void push(int x) {
		stack.push(x);
		if(minStack.isEmpty() || minStack.peek() >= x)
			minStack.push(x);
	}

	public void pop() {
		int item = stack.pop();
		if(minStack.peek() == item)
			minStack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.isEmpty() ? 0: minStack.peek();
	}
}

public class MinStackLeetCode155 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
