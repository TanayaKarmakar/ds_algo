package com.app.practice.queue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NumbersWithSameConsecutiveDifferencesLeetcode867 {
	private static int[] numsSameConsecDiff(int n, int k) {
		if (n == 1) {
			int[] res = new int[10];
			for (int i = 0; i < 10; i++) {
				res[i] = i;
			}
			return res;
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= 9; i++) {
			q.add(i);
		}

		Set<Integer> list = new HashSet<>();
		while (!q.isEmpty()) {
			int curr = q.poll();

			String str = String.valueOf(curr);

			if (str.length() == n) {
				list.add(curr);
				continue;
			}

			int r = curr % 10;
			int diff1 = r - k;
			if (diff1 >= 0 && diff1 <= 9)
				q.add((curr * 10) + diff1);
			diff1 = r + k;
			if (diff1 >= 0 && diff1 <= 9)
				q.add((curr * 10) + diff1);
		}

		int size = list.size();
		int[] res = new int[size];
		int i = 0;

		for (int el : list) {
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
