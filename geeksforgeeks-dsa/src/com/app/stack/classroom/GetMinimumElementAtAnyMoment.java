package com.app.stack.classroom;

import java.util.Stack;

class EnhancedStack {
	private Stack<Integer> mainStack = new Stack<>();
	private Stack<Integer> auxStack = new Stack<>();
	
	public void push(int data) {
		mainStack.push(data);
		if(auxStack.isEmpty() || auxStack.peek() >= data) {
			auxStack.push(data);
		}
	}
	
	public void pop() {
		if(!mainStack.isEmpty()) {
			int item = mainStack.pop();
			if(!auxStack.isEmpty() && item == auxStack.peek()) {
				auxStack.pop();
			}
		}
	}
	
	public int getMinimum() {
		return auxStack.peek();
	}
}

public class GetMinimumElementAtAnyMoment {
	public static void main(String[] args) {
		EnhancedStack eStack = new EnhancedStack();
		eStack.push(5);
		eStack.push(10);
		eStack.push(20);
		eStack.push(2);
		eStack.push(6);
		eStack.push(4);
		
		eStack.pop();
		eStack.pop();
		
		System.out.println("Minimum at this moment - " + eStack.getMinimum());
		
		eStack.push(2);
		eStack.pop();
		
		System.out.println("Minimum at this moment - " + eStack.getMinimum());
		
		eStack.push(1);
		eStack.pop();
		eStack.pop();
		System.out.println("Minimum at this moment - " + eStack.getMinimum());
	}

}
