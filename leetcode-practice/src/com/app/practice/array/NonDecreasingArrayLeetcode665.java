package com.app.practice.array;

public class NonDecreasingArrayLeetcode665 {
	private static boolean checkPossibility(int[] nums) {
		int n = nums.length;
		
		int count = 0;
		for(int i = 0; i < n - 1; i++) {
			if(nums[i] > nums[i + 1]) {
				count++;
				if(count > 1)
					return false;
				
				if(i > 0 && nums[i + 1] < nums[i - 1])
					nums[i + 1] = nums[i];
				else
					nums[i] = nums[i + 1];
			}
		}
		
		return count <= 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
