package com.app.heap.classroom;

public class MinHeap {
	int[] arr;
	int size;
	int capacity;
	private static final int FRONT = 1;

	public MinHeap(int capacity) {
		this.capacity = capacity;
		this.arr = new int[this.capacity + 1];
		this.size = 0;
		this.arr[0] = Integer.MIN_VALUE;
	}

	public int left(int i) {
		return 2 * i;
	}

	public int right(int i) {
		return (2 * i + 1);
	}

	public int parent(int i) {
		return i / 2;
	}

	public void insert(int el) {
		if (size >= capacity)
			return;
		arr[++size] = el;
		int current = size;
		while (arr[current] < arr[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}

	}

	public void printHeap() {
		System.out.println("Current Size - " + size);
		int lim = size / 2;
		for (int i = 1; i <= lim; i++) {
			System.out.println("Parent - " + arr[i]);
			if(arr[2 * i] != 0) {
				System.out.println("Left Child - " + arr[2 * i]);
			}
			if(arr[2 * i + 1] != 0) {
				System.out.println("Right Child - " + arr[2 * i + 1]);
			}	
		}
	}

	public void minHeapify(int pos) {
		if (!isLeaf(pos)) {
			if (arr[pos] > arr[left(pos)] || arr[pos] > arr[right(pos)]) {
				if (arr[left(pos)] < arr[right(pos)]) {
					swap(pos, left(pos));
					minHeapify(left(pos));
				} else {
					swap(pos, right(pos));
					minHeapify(right(pos));
				}
			}
		}
	}

	public int remove() {
		int el = arr[FRONT];
		arr[FRONT] = arr[size];
		
		arr[size] = 0;
		size--;
		minHeapify(FRONT);
		return el;
	}

	private boolean isLeaf(int pos) {
		if (pos >= size / 2 && pos <= size)
			return true;
		return false;
	}

	private void swap(int pos1, int pos2) {
		int tmp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = tmp;
	}

}
