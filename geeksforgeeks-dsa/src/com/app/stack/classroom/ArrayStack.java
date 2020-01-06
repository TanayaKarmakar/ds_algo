package com.app.stack.classroom;

public class ArrayStack<T> {
	private static final int MAX_CAPACITY = 10;
	private T[] arr;
	private int top;

	public ArrayStack() {
		this.arr = (T[]) new Object[MAX_CAPACITY];
		this.top = -1;
	}

	public void push(T data) {
		if (top == MAX_CAPACITY) {
			throw new StackFullException("Stack is full");
		}
		top++;
		this.arr[top] = data;
	}

	public T pop() {
		if (top == -1) {
			throw new StackEmptyException("Stack is empty");
		}
		T res = this.arr[top];
		top--;
		return res;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}

}
