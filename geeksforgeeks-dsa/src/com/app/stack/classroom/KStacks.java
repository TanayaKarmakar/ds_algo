package com.app.stack.classroom;

import java.util.Arrays;

public class KStacks {
	int[] arr;
	private final int MAX_CAPACITY;
	private final int k;
	private int[] next;
	private int[] top;
	private int free;

	public KStacks(int k, int cap) {
		this.k = k;
		this.MAX_CAPACITY = cap;
		this.top = new int[k];
		this.next = new int[MAX_CAPACITY];
		this.arr = new int[MAX_CAPACITY];
		Arrays.fill(top, -1);
		for (int i = 0; i < MAX_CAPACITY; i++) {
			next[i] = i + 1;
		}
		next[MAX_CAPACITY - 1] = -1;
		free = 0;
	}

	public void push(int data, int sn) {
		if (isFull())
			throw new StackFullException("Stack is full");
		int i = free;
		free = next[i];
		next[i] = top[sn];
		top[sn] = i;
		arr[i] = data;
	}

	public int pop(int sn) {
		if (isEmpty(sn))
			throw new StackEmptyException("Stack is empty");
		int i = top[sn];
		top[sn] = next[i];
		next[i] = free;
		free = i;
		return arr[i];
	}

	public boolean isEmpty(int sn) {
		return top[sn] == -1;
	}

	public boolean isFull() {
		return free == -1;
	}

}
