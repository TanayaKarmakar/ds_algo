package com.app.problems.gfg.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaximumSum {
	private static int divideAndSum(Map<String, Integer> map, int n1, int n2, int n3) {
		if ((n1 + n2 + n3) == 0)
			return 0;
		String key = n1 + "-" + n2 + "-" + n3;
		if(map.containsKey(key))
			return map.get(key);
		int sum = (n1 + n2 + n3);
		int newN1 = divideAndSum(map, n1 / 2, n1 / 3, n1 / 4);
		int newN2 = divideAndSum(map, n2 / 2, n2 / 3, n2 / 4);
		int newN3 = divideAndSum(map, n3 / 2, n3 / 3, n3 / 4);
		int newSum = (Integer.max(n1, newN1) 
				+ Integer.max(n2, newN2) + Integer.max(n3, newN3));
		int val = Integer.max(sum, newSum);
		map.put(key, val);
		return val;
	}

	private static int getMaxSum(int n) {
		Map<String, Integer> map = new HashMap<>();
		return divideAndSum(map, n / 2, n / 3, n / 4);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		while (nTestCases-- > 0) {
			int n = scanner.nextInt();
			int maxSum = getMaxSum(n);
			System.out.println(maxSum);
		}
		scanner.close();
	}

}
