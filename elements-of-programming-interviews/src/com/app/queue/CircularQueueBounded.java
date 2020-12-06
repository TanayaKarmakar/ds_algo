package com.app.queue;

import java.util.Iterator;

public class CircularQueueBounded {
	Integer[] arr;
	int maxCapacity;
	int front;
	int rear;
	int elCount;

	public CircularQueueBounded(int maxCapacity) {
		this.maxCapacity = maxCapacity;
		this.arr = new Integer[maxCapacity];
		front = rear = -1;
		elCount = 0;
	}

	public void add(int item) {
		if (elCount == maxCapacity) {
			System.out.println("Queue is full");
			return;
		}

		if(front == -1)
			front++;
		rear = (rear + 1) % maxCapacity;
		arr[rear] = item;
		elCount++;
	}

	public int poll() {
		if (elCount == 0) {
			throw new RuntimeException("Queue is empty");
		}
		int item = arr[front];
		front = (front + 1) % maxCapacity;
		elCount--;
		return item;
	}

	public Iterator<Integer> iterator() {
		return createIterator();
	}

	private Iterator<Integer> createIterator() {
		return new QueueIterator<Integer>(arr, front, rear, maxCapacity);
	}
}
