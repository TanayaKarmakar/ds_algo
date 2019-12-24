package com.app.hashing.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ZeroSumSubarrays {
	private static int countZeroSum(int[] arr, int n) {
		Map<Integer, Integer> map = new HashMap<>();
		int res = 0;
		int preSum = 0;
		for (int i = 0; i < n; i++) {
			preSum += arr[i];
			if (preSum == 0)
				res++;

			if (!map.containsKey(preSum)) {
				map.put(preSum, 1);
			} else {
				res += map.get(preSum);
				int tmp = map.get(preSum);
				map.put(preSum, ++tmp);
			}
		}

		return res;
	}

	public static void main(String[] args) {
//		int[] arr = { 0, 0, 5, 5, 0, 0 };
//
//		System.out.println("Count - " + countZeroSum(arr));
//
//		arr = new int[] { 6, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
//		
//		System.out.println("Count - " + countZeroSum(arr));

		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		StringBuilder sb = new StringBuilder();

		while (nTestCases > 0) {
			int nDim = scanner.nextInt();
			int[] arr = new int[nDim];
			for (int i = 0; i < nDim; i++) {
				arr[i] = scanner.nextInt();
			}
			sb.append(countZeroSum(arr, nDim) + "\n");
			nTestCases--;
		}
		System.out.print(sb.toString());
		scanner.close();

	}

}
