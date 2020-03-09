package com.app.dynamicprogramming.classroom;

//it is binary search based solution
//time complexity -- O(n*logn)
public class LongestIncreasingSubsequenceApproach2 {
	private static int getCeilIndx(int[] tail, int l, int r, int x) {
		while (l < r) {
			int m = l + (r - l) / 2;
			if (tail[m] >= x) {
				r = m;
			} else {
				l = m + 1;
			}
		}

		return r;
	}

	private static int lis(int[] nums) {
		int n = nums.length;
		int[] tail = new int[n];
		int len = 1;
		tail[0] = nums[0];

		for (int i = 1; i < n; i++) {
			if (tail[len - 1] < nums[i]) {
				tail[len] = nums[i];
				len++;
			} else {
				int indx = getCeilIndx(tail, 0, len - 1, nums[i]);
				tail[indx] = nums[i];
			}
		}

		return len;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 4, 2, 8, 10 };
		
		System.out.println("LIS - " + lis(nums));
	}

}
