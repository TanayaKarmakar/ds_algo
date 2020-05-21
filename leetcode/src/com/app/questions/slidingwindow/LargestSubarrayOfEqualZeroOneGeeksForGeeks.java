package com.app.questions.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayOfEqualZeroOneGeeksForGeeks {
	private static int maxLen(int[] nums, int n) {
		Map<Integer, Integer> map = new HashMap<>();
		int preSum = 0;
		
		int maxLen = 0;
		for(int i = 0; i < n; i++) {
			if(nums[i] == 0)
				preSum += (-1);
			if(nums[i] == 1)
				preSum += nums[i];
			
			if(preSum == 0)
				maxLen = i + 1;
			if(map.containsKey(preSum))
				maxLen = Integer.max(maxLen, i - map.get(preSum));
			else
				map.put(preSum, i);
		}
		return maxLen;
	}

	public static void main(String[] args) {
		int[] nums = {0, 1, 0, 1};
		int maxLen = maxLen(nums, 4);
		
		System.out.println(maxLen);

	}

}
