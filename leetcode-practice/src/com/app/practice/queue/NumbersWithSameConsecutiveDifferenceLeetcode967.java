package com.app.practice.queue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NumbersWithSameConsecutiveDifferenceLeetcode967 {
	private static int[] numsSameConsecDiff(int n, int k) {
		if (n == 1)
			return new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Queue<Integer> q = new LinkedList<>();

		Set<Integer> numSet = new HashSet<>();
		for (int i = 1; i <= 9; i++) {
			q.add(i);
		}

		while (!q.isEmpty()) {
			int item = q.poll();

			if (String.valueOf(item).length() == n) {
				numSet.add(item);
				continue;
			}

			int lastDigit = item % 10;
			int plusK = lastDigit + k;
			if (plusK >= 0 && plusK <= 9) {
				q.add(item * 10 + plusK);
			}

			int minusK = lastDigit - k;
			if (minusK >= 0 && minusK <= 9)
				q.add(item * 10 + minusK);
		}

		int[] res = new int[numSet.size()];

		int i = 0;
		for (Integer el : numSet) {
			res[i++] = el;
		}

		return res;
	}

	public static void main(String[] args) {
		int n = 3;
		int k = 7;
		
		int[] res = numsSameConsecDiff(n, k);
		
		System.out.println(Arrays.toString(res));

	}

}
