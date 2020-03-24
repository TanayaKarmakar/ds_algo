package com.app.searching.practice;

public class AllocateMinimumNumberofPages {
	private static boolean isValidConfiguration(int[] nums, int students, int mid) {
		int studCount = 1;
		int pageCount = 0;

		for (int i = 0; i < nums.length; i++) {
			if(nums[i] > mid)
				return false;
			if (pageCount + nums[i] <= mid) {
				pageCount += nums[i];
			} else {
				pageCount = nums[i];
				studCount++;

				if (studCount > students)
					return false;
			}
		}

		return true;
	}

	private static int findMinimumPages(int[] nums, int students) {
		int totalSum = 0;
		int start = 0;
		for (int num : nums) {
			totalSum += num;
			//start = Integer.max(start, num);
		}

		int end = totalSum;
		int finalAns = Integer.MAX_VALUE;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (isValidConfiguration(nums, students, mid)) {
				finalAns = Integer.min(finalAns, mid);
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return finalAns;
	}

	public static void main(String[] args) {
		int[] nums = { 12, 34, 67, 90 };
		int m = 2;
		int ans = findMinimumPages(nums, m);
		
		System.out.println(ans);

	}

}
