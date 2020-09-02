package com.app.practice.graphbfsdfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class NumbersWithSameConsecutiveDifferenceLeetcode967 {
	private static int[] numsSameConsecDiff(int N, int K) {
		if (N == 1) {
			int[] res = new int[10];
			for (int i = 0; i <= 9; i++) {
				res[i] = i;
			}
			return res;
		}

		Queue<Integer> q = new LinkedList<>();
		Set<Integer> set = new HashSet<>();

		for (int i = 1; i <= 9; i++) {
			q.add(i);
		}

		while (!q.isEmpty()) {
			int n = q.poll();
			String numStr = String.valueOf(n);

			if (numStr.length() == N) {
				set.add(n);
				continue;
			}

			int r = n % 10;
			int n1 = r + K;
			int n2 = r - K;

			if (n1 >= 0 && n1 <= 9) {
				q.add((n * 10) + n1);
			}

			if (n2 >= 0 && n2 <= 9) {
				q.add((n * 10) + n2);
			}
		}

		int size = set.size();
		int i = 0;
		int[] res = new int[size];
		for (Integer el : set) {
			res[i++] = el;
		}

		return res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		int K = scanner.nextInt();
		
		int[] res = numsSameConsecDiff(N, K);
		
		System.out.println(Arrays.toString(res));
		
		scanner.close();
	}

}
