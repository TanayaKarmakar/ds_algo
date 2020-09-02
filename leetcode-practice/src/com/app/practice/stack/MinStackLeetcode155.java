package com.app.practice.stack;

import java.util.Stack;

class MinStack {
	Stack<Integer> stack;
	Stack<Integer> mStack;

    public MinStack() {
        stack = new Stack<>();
        mStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(mStack.isEmpty() || mStack.peek() > x) {
        	mStack.push(x);
        }
    }
    
    public void pop() {
        int el = stack.pop();
        if(mStack.peek() == el)
        	mStack.pop();
    }
    
    public int top() {
        return stack.isEmpty() ? Integer.MAX_VALUE : stack.peek();
    }
    
    public int getMin() {
        return mStack.isEmpty() ? Integer.MAX_VALUE : mStack.peek();
    }
}

public class MinStackLeetcode155 {

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		
		System.out.println(minStack.getMin());
		
		minStack.pop();
		
		System.out.println(minStack.top());
		
		System.out.println(minStack.getMin());

	}

}
