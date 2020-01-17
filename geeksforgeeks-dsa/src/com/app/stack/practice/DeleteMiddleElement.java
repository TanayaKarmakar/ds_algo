package com.app.stack.practice;

import java.util.Iterator;
import java.util.Stack;

public class DeleteMiddleElement {
	private static void deleteMidEl(Stack<Integer> stack, int sizeOfStack, int current) {
		if(stack.isEmpty() || current == sizeOfStack)
			return;
		int x = stack.pop();
		deleteMidEl(stack, sizeOfStack, current + 1);
		
		
		if(current != sizeOfStack/2) {
			stack.push(x);
		}
	}
	
	private static Stack<Integer> deleteMid(Stack<Integer> stack, int sizeOfStack, 
			int current) {
		deleteMidEl(stack, sizeOfStack, current);
		return stack;
			
	}

	public static void main(String[] args) {
		Stack<Integer> numStack = new Stack<>();
		numStack.push(1);
		numStack.push(2);
		numStack.push(3);
		numStack.push(4);
		numStack.push(5);
		
		numStack = deleteMid(numStack, numStack.size(), 0);
		
		Iterator<Integer> stackIterator = numStack.iterator();
		
		while(stackIterator.hasNext()) {
			System.out.print(stackIterator.next() + " ");
		}
		System.out.println();
		
		while(!numStack.isEmpty()) {
			System.out.print(numStack.pop() + " ");
		}
		System.out.println();

	}

}
