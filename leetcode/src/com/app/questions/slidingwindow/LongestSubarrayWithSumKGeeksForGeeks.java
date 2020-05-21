package com.app.questions.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubarrayWithSumKGeeksForGeeks {
	private static int longestSubarray(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int preSum = 0;
		
		int n = nums.length;
		int maxLen = 0;
		for(int i = 0; i < n; i++) {
			preSum += nums[i];
			if(preSum == target)
				maxLen = i + 1;
			if(map.containsKey(preSum - target))
				maxLen = Integer.max(maxLen, i - map.get(preSum - target));
			if(!map.containsKey(preSum))
				map.put(preSum, i);
		}
		return maxLen;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		while(nTestCases-- > 0) {
			int n = scanner.nextInt();
			int target = scanner.nextInt();
			
			int[] nums = new int[n];
			for(int i = 0; i < n; i++) {
				nums[i] = scanner.nextInt();
			}
			int largestSubarray = longestSubarray(nums, target);
			System.out.println(largestSubarray);
			
		}
		scanner.close();
	}

}
