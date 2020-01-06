package com.app.stack.classroom;

import java.util.Arrays;

public class KStacks1 {
	private final int MAX_CAPACITY;
	private final int k;
	private int[] arr;
	private int[] next;
	private int[] top;
	private int freeTop;

	public KStacks1(int[] arr, int k, int n) {
		this.MAX_CAPACITY = n;
		this.k = k;
		this.arr = new int[MAX_CAPACITY];
		this.next = new int[MAX_CAPACITY];
		this.top = new int[k];

		Arrays.fill(top, -1);
		for (int i = 0; i < MAX_CAPACITY - 1; i++) {
			this.next[i] = i + 1;
		}
		this.next[MAX_CAPACITY - 1] = -1;
		freeTop = 0;
	}
	
	public void push(int data, int sn) {
		int i = freeTop;
		freeTop = next[i];
		next[i] = top[sn];
		top[sn] = i;
		arr[i] = data;
	}
	
	public int pop(int sn) {
		int i = top[sn];
		top[sn] = next[i];
		next[i] = freeTop;
		freeTop = i;
		return arr[i];
	}

}
