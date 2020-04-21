package com.app.questions.read;

public class ShortestUnsortedArrayLeetcode581 {
	private static int shortestUnsortedArray(int[] nums) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		int n = nums.length;
		for(int i = 1; i < n; i++) {
			if(nums[i - 1] > nums[i]) {
				min = Integer.min(min, nums[i]);
			}
		}
		
		for(int j = n - 2; j >= 0; j--) {
			if(nums[j + 1] < nums[j]) {
				max = Integer.max(max, nums[j]);
			}
		}
		
		int l = 0;
		for(l = 0; l < n; l++) {
			if(min < nums[l])
				break;
		}
		
		int r = n - 1;
		for(r = n - 1; r >= 0; r--) {
			if(max > nums[r])
				break;
		}
		
		return (r - l) < 0 ? 0: (r - l) + 1;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 2, 2, 2 };
		int len = shortestUnsortedArray(nums);

		System.out.println(len);
	}

}
