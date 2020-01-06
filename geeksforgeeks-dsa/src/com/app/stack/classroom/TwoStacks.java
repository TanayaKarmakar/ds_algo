package com.app.stack.classroom;

public class TwoStacks {
	private static final int MAX_CAPACITY = 30;
	private int[] arr;
	private int top1;
	private int top2;

	public TwoStacks() {
		this.arr = new int[MAX_CAPACITY];
		top1 = -1;
		top2 = MAX_CAPACITY;
	}

	public void push1(int data) {
		if (top1 == top2 - 1)
			throw new StackFullException("Stack is full");
		top1++;
		this.arr[top1] = data;
	}

	public void push2(int data) {
		if (top1 == top2 - 1)
			throw new StackFullException("Stack is full");
		top2--;
		this.arr[top2] = data;
	}

	public int pop1() {
		if (top1 == -1)
			throw new StackEmptyException("Stack is empty");
		int data = this.arr[top1];
		top1--;
		return data;
	}

	public int pop2() {
		if (top2 == MAX_CAPACITY)
			throw new StackEmptyException("Stack is empty");
		int data = this.arr[top2];
		top2++;
		return data;
	}

	public int size1() {
		return top1 + 1;
	}

	public int size2() {
		return MAX_CAPACITY - top2;
	}
	
	public boolean isEmpty1() {
		return top1 == -1;
	}
	
	public boolean isEmpty2() {
		return top2 == MAX_CAPACITY;
	}
}
