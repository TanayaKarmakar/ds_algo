package com.app.questions.dp;

public class NumberOfLISLeetcode673 {
	private static int numberOfLIS(int[] nums) {
		int[] lis = new int[nums.length];
		int[] count = new int[nums.length];
		
		lis[0] = 1;
		count[0] = 1;
		int maxLen = 1;
		for(int i = 1; i < nums.length; i++) {
			lis[i] = 1;
			count[i] = 1;
			for(int j = 0; j < i; j++) {
				if(nums[j] < nums[i]) {
					if(lis[j] >= lis[i]) {
						lis[i] = lis[j] + 1;
						count[i] = count[j];
					} else if(lis[j] + 1 == lis[i]) {
						count[i] = count[i] + count[j];
					}
				}
			}
			maxLen = Integer.max(maxLen, lis[i]);
		}
		
		int cnt = 0;
		for(int i = 0; i < nums.length; i++) {
			if(lis[i] == maxLen) {
				cnt += count[i];
			}
		}
		
		return cnt;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 4, 7 };

		System.out.println(numberOfLIS(nums));

		nums = new int[] { 2, 2, 2, 2, 2 };
		
		System.out.println(numberOfLIS(nums));

	}

}
