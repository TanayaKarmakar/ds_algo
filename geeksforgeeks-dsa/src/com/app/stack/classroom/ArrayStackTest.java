package com.app.stack.classroom;

public class ArrayStackTest {

	public static void main(String[] args) {
		ArrayStack<Integer> stack = new ArrayStack<>();
		
		stack.push(10);
		stack.push(20);
		stack.push(30);
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}

		System.out.println(stack.pop());
	}

}
