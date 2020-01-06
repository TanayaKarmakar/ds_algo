package com.app.stack.classroom;

public class LinkedListStackTest {

	public static void main(String[] args) {
		LinkedListStack<Integer> stack = new LinkedListStack<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
		stack.pop();

	}

}
