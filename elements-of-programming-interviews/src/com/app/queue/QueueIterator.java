package com.app.queue;

import java.util.Iterator;

public class QueueIterator<E> implements Iterator<E> {
	E[] arr;
	int start;
	int end;
	int totalSize;
	
	public QueueIterator(E[] arr, int start, int end, int totalSize) {
		this.arr = arr;
		this.start = start;
		this.end = end;
		this.totalSize = totalSize;
	}

	@Override
	public boolean hasNext() {
		if(start == end)
			return false;
		return true;
	}

	@Override
	public E next() {
		if(hasNext()) {
			E item = arr[start];
			start = (start + 1) % totalSize;
			return item;
		}
		return null;
	}

}
