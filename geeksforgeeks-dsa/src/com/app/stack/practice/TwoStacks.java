package com.app.stack.practice;

public class TwoStacks {
	private int[] arr;
	private final int MAX_SIZE = 100;
	private int top1;
	private int top2;
	
	public TwoStacks() {
		this.arr = new int[MAX_SIZE];
		this.top1 = -1;
		this.top2 = arr.length;
	}
	
	public void push1(int data) {
		if(top1 == top2 - 1)
			return;
		++top1;
		arr[top1] = data;
	}
	
	public void push2(int data) {
		if(top1 == top2 - 1)
			return;
		--top2;
		arr[top2] = data;
	}
	
	public int pop1() {
		if(top1 == -1)
			return -1;
		int el = arr[top1];
		--top1;
		return el;
	}
	
	public int pop2() {
		if(top2 == MAX_SIZE)
			return -1;
		int el = arr[top2];
		--top2;
		return el;
	}
	

	public static void main(String[] args) {
		TwoStacks tStacks = new TwoStacks();
		tStacks.push1(2);
		tStacks.push1(3);
		
		System.out.println("Top data - " + tStacks.pop1());

	}

}
