package com.app.queue.practice;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumOfAllSubarrays {
	private static void maximumOfSubarray(int[] arr, int k) {
		Deque<Integer> dq = new LinkedList<>();

		int n = arr.length;
		for (int i = 0; i < k; i++) {
			while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
				dq.removeLast();
			}
			dq.addLast(i);
		}

		for (int i = k; i < n; i++) {
			System.out.print(arr[dq.peek()] + " ");
			while (!dq.isEmpty() && dq.peek() <= (i - k)) {
				dq.removeFirst();
			}

			while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
				dq.removeLast();
			}
			dq.addLast(i);
		}

		System.out.print(arr[dq.peek()]);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
		maximumOfSubarray(arr, 3);

	}

}
