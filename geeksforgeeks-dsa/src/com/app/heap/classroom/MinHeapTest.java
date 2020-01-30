package com.app.heap.classroom;

public class MinHeapTest {

	public static void main(String[] args) {
		int[] items = { 5, 3, 17, 10, 84, 19, 6, 22, 9 };
		MinHeap minHeap = new MinHeap(15);

		for (int i = 0; i < items.length; i++) {
			minHeap.insert(items[i]);
		}
		
		minHeap.printHeap();
		
		int el = minHeap.remove();
		
		System.out.println("Removed Element - " + el);
		
		System.out.println("After removal and heapification");
		
		minHeap.printHeap();

	}

}
