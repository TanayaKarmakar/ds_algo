package com.app.practice.math;

public class RandomPickByWeightLeetcode528 {
	private int[] preSum;
	private static int sum;

	public RandomPickByWeightLeetcode528(int[] nums) {
		int n = nums.length;
		preSum = new int[n];

		sum = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			preSum[i] = sum;
		}
	}

	public int pickIndx() {
		int randNum = (int) (Math.random() * sum) + 1;
		int indx = findFloor(randNum);
		return indx;
	}

	private int findFloor(int key) {
		int low = 0;
		int high = preSum.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (preSum[mid] == key)
				return mid;
			else if (preSum[mid] < key)
				low = mid + 1;
			else {
				high = mid - 1;
			}
		}
		return low;
	}

	public static void main(String[] args) {
		RandomPickByWeightLeetcode528 obj 
		= new RandomPickByWeightLeetcode528(new int[] { 1, 3 });

		System.out.println(obj.pickIndx());
		System.out.println(obj.pickIndx());
	}

}
