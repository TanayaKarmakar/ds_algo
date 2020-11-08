package com.app.practice.dp;

public class NumberIfLISLeetcode673 {
	private static int findNumberOfLIS(int[] nums) {
		int n = nums.length;
		int[] lis = new int[n];
		int[] count = new int[n];

		lis[0] = 1;
		count[0] = 1;
		int maxLen = 1;

		for (int i = 0; i < n; i++) {
			lis[i] = 1;
			count[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					if (lis[j] >= lis[i])
						count[i] = count[j];
					else if (lis[i] == lis[j] + 1)
						count[i] += count[j];
					lis[i] = Integer.max(lis[i], lis[j] + 1);
				}
			}
			maxLen = Integer.max(maxLen, lis[i]);
		}

		int totalCount = 0;

		for (int i = 0; i < n; i++) {
			if (lis[i] == maxLen)
				totalCount += count[i];
		}

		return totalCount;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 4, 7 };

		int ans = findNumberOfLIS(nums);

		System.out.println(ans);

		nums = new int[] { 2, 2, 2, 2, 2 };
		
		ans = findNumberOfLIS(nums);

		System.out.println(ans);


	}

}
