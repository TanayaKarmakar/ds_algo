package com.app.queue.practice;

public class ArrayQueue {
	private int[] arr;
	private final int MAX_SIZE = 100;
	private int front;
	private int rear;
	private int size;

	public ArrayQueue() {
		this.arr = new int[MAX_SIZE];
		front = -1;
		rear = -1;
		size = 0;
	}
	
	private boolean isFull() {
		return size == MAX_SIZE;
	}
	
	private boolean isEmpty() {
		return size == 0;
	}

	public void add(int data) {
		if(isFull())
			return;
		if (front == -1) {
			front = 0;
			rear = 0;
		} else {
			rear = (rear + 1) % MAX_SIZE;
		}
		++size;
		arr[rear] = data;
	}

	public int remove() {
		if(isEmpty())
			return -1;
		--size;
		int el = arr[front];
		front = (front + 1) % MAX_SIZE;
		return el;
	}

	public static void main(String[] args) {
		ArrayQueue aq = new ArrayQueue();
		aq.add(1);
		aq.add(2);
		aq.add(3);
		aq.add(4);
		aq.add(5);
		aq.add(6);
		
		System.out.println("Popped item - " + aq.remove());
		System.out.println("Popped item - " + aq.remove());

	}

}
