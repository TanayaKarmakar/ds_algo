package com.app.heap.classroom;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfAStream {
	private static void medianOfAStream(int[] arr) {
		PriorityQueue<Integer> s = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> g = new PriorityQueue<>();

		s.add(arr[0]);
		System.out.print(arr[0] + " ");
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int x = arr[i];
			if (s.size() > g.size()) {
				if (s.peek() > x) {
					g.add(s.poll());
					s.add(x);
				} else {
					g.add(x);
				}
				System.out.print((s.peek() + g.peek()) / 2.0 + " ");
			} else {
				if (x <= s.peek()) {
					s.add(x);
				} else {
					g.add(x);
					s.add(g.poll());
				}
				System.out.print(s.peek() + " ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 12, 15, 10, 5, 8, 7, 16 };
		medianOfAStream(arr);

	}

}
