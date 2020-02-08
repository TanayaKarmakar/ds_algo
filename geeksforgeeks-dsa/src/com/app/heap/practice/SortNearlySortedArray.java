package com.app.heap.practice;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortNearlySortedArray {
	private static void nearlySortedArray(int[] arr, int k) {
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		for (int i = 0; i <= k; i++) {
			pQ.add(arr[i]);
		}

		int indx = 0;
		for (int i = k + 1; i < arr.length; i++) {
			arr[indx++] = pQ.poll();
			pQ.add(arr[i]);
		}
		
		while(!pQ.isEmpty() && indx < arr.length) {
			arr[indx++] = pQ.poll();
		}

		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		int[] arr = { 6, 5, 3, 2, 8, 10, 9 };
		nearlySortedArray(arr, 3);
		
	}

}
