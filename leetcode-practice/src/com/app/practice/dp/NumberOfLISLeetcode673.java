package com.app.practice.dp;

public class NumberOfLISLeetcode673 {

	private static int numberOfLIS(int[] nums) {
		int n = nums.length;
		int[] lis = new int[n];
		int[] count = new int[n];

		lis[0] = 1;
		count[0] = 1;

		int max = 1;

		for (int i = 1; i < n; i++) {
			lis[i] = 1;
			count[i] = 1;
			for (int j = 0; j < n; j++) {
				if (nums[j] < nums[i]) {
					if (lis[j] >= lis[i]) {
						lis[i] = lis[j] + 1;
						count[i] = count[j];
					} else if (lis[j] + 1 == lis[i]) {
						count[i] = count[i] + count[j];
					}
				}
			}
			max = Integer.max(lis[i], max);
		}

		int total = 0;
		for (int i = 0; i < n; i++) {
			if (lis[i] == max) {
				total += count[i];
			}
		}

		return total;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 4, 7 };
		int ans = numberOfLIS(nums);
		
		System.out.println(ans);
	}

}
