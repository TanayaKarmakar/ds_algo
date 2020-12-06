package com.app.stack;

import java.util.ArrayDeque;
import java.util.Deque;

//problem 1
class StackElement {
	int currentElement;
	int maxElement;

	public StackElement(int currentElement, int maxElement) {
		this.currentElement = currentElement;
		this.maxElement = maxElement;
	}
}

class Stack {
	Deque<StackElement> maxStack;

	public Stack() {
		maxStack = new ArrayDeque<>();
	}

	public void push(int element) {
		int max = isEmpty() ? element : Integer.max(max(), element);
		StackElement stackElement = new StackElement(element, max);
		maxStack.push(stackElement);
	}

	public int pop() {
		return maxStack.pollFirst().currentElement;
	}

	public int peek() {
		return maxStack.peekFirst().currentElement;
	}

	public boolean isEmpty() {
		return maxStack.isEmpty();
	}

	public int max() {
		return maxStack.peekFirst().maxElement;
	}
}

public class MaxElement {

	public static void main(String[] args) {
		int[] nums = { 1, 8, 5, 7, 2, 6, 3, 4 };
		Stack stack = new Stack();

		for (int el : nums) {
			stack.push(el);
		}
		
		while(!stack.isEmpty()) {
			System.out.println("**************************************");
			System.out.println("Current Max - " + stack.max());
			System.out.println("Current Popped Element - " + stack.pop());
			System.out.println("**************************************");
		}
	}

}
