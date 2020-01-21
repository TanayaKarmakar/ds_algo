package com.app.queue.classroom;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumOfAllSubarrays {
	private static void printGreaterElements(int[] arr, int k) {
		Deque<Integer> dq = new LinkedList<>();

		for (int i = 0; i < k; i++) {
			while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
				dq.removeLast();
			}
			dq.addLast(i);
		}

		int n = arr.length;
		for (int i = k; i < n; i++) {
			System.out.print(arr[dq.peek()] + " ");
			while (!dq.isEmpty() && dq.peek() <= (i - k))
				dq.removeFirst();
			while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
				dq.removeLast();
			}
			dq.addLast(i);
		}
		System.out.print(arr[dq.peek()]);
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 10, 8, 5, 12, 15, 7, 6 };
		int k = 3;
		printGreaterElements(arr, k);
	}
}
