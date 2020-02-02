package com.app.recursion.practice;

import java.util.Stack;

public class ReverseStack {
	private static void reverseStack(Stack<Integer> numStack) {
		if (numStack.isEmpty())
			return;
		int item = numStack.pop();
		reverseStack(numStack);
		numStack.push(item);
		System.out.println(numStack.peek());
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		reverseStack(stack);

	}

}
