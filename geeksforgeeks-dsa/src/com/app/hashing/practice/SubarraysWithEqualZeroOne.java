package com.app.hashing.practice;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithEqualZeroOne {
	private static int equalZeroOneCount(int[] arr) {
		int n = arr.length;

		int res = 0;
		int preSum = 0;

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				preSum -= 1;
			} else {
				preSum += arr[i];
			}

			if (preSum == 0) {
				res++;
			}
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
		int[] arr = { 1, 0, 0, 1, 0, 1, 1 };
		System.out.println("EqualZeroOneCount - " + equalZeroOneCount(arr));
	}

}
