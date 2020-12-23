package com.app.priorityqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class HeapEntry {
	public Integer index;
	public Integer value;
	
	public HeapEntry(Integer index, Integer value) {
		this.index = index;
		this.value = value;
	}
}

public class ComputeKLargestElementsInMaxHeap {
	private static List<Integer> kLargestInBinaryHeap(List<Integer> A, int k) {
		if(k == 0) {
			return Collections.emptyList();
		}
		
		PriorityQueue<HeapEntry> maxHeap = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);
		maxHeap.add(new HeapEntry(0, A.get(0)));
		
		List<Integer> result = new ArrayList<>();
		
		for(int i = 0; i < k; i++) {
			HeapEntry heapEntry = maxHeap.poll();
			int indx = heapEntry.index;
			int value = heapEntry.value;
			
			result.add(value);
			
			int leftIndx = 2 * indx + 1;
			if(leftIndx < A.size()) {
				maxHeap.add(new HeapEntry(leftIndx, A.get(leftIndx)));
			}
			
			int rightIndx = 2 * indx + 2;
			if(rightIndx < A.size()) {
				maxHeap.add(new HeapEntry(rightIndx, A.get(rightIndx)));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(561, 314, 401, 28, 156, 359, 271, 11, 3);
		
		List<Integer> result = kLargestInBinaryHeap(numbers, 3);
		
		System.out.println(result);

	}

}
