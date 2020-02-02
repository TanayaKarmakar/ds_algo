package com.app.heap.classroom;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortKSortedArray {
	private static void sortKSortedArray(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i <= k; i++) {
			pq.add(arr[i]);
		}

		int n = arr.length;
		int indx = 0;
		for (int i = k + 1; i < n; i++) {
			arr[indx++] = pq.poll();
			pq.add(arr[i]);
		}

		while (!pq.isEmpty()) {
			arr[indx++] = pq.poll();
		}
	}

	public static void main(String[] args) {
		int[] arr = { 9, 8, 7, 10, 15, 12 };
		int k = 2;
		sortKSortedArray(arr, k);
		
		System.out.println("After sorting, the array is");
		System.out.println(Arrays.toString(arr));
	}

}
