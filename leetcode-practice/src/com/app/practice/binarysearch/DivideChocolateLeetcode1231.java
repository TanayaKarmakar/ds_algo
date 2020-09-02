package com.app.practice.binarysearch;

public class DivideChocolateLeetcode1231 {
	private static boolean canDivide(int[] sweetness, int mid, int k) {
		int cnt = 0;
		int sum = 0;

		for (int i = 0; i < sweetness.length; i++) {
			sum += sweetness[i];

			if (sum >= mid) {
				cnt++;
				sum = 0;
			}
		}

		return cnt >= k;
	}

	private static int maximizeSweetness(int[] sweetness, int K) {
		int total = 0;
		for (int num : sweetness) {
			total += num;
		}

		int low = 0;
		int high = total;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (canDivide(sweetness, mid, K + 1)) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return low - 1;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int k = 5;

		int maxSweetness = maximizeSweetness(nums, k);

		System.out.println(maxSweetness);

		nums = new int[] { 5, 6, 7, 8, 9, 1, 2, 3, 4 };
		k = 8;

		maxSweetness = maximizeSweetness(nums, k);

		System.out.println(maxSweetness);

		nums = new int[] { 1, 2, 2, 1, 2, 2, 1, 2, 2 };
		k = 2;

		maxSweetness = maximizeSweetness(nums, k);

		System.out.println(maxSweetness);
	}

}
