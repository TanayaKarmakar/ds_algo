package com.app.search;

public class SearchInSortedArrayForEntryEqualsIndex {
	private static int getIndx(int[] nums) {
		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			int diff = nums[mid] - mid;
			if (diff == 0)
				return mid;
			else if (diff < 0)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { -2, 0, 2, 3, 6, 7, 9 };
		
		int indx = getIndx(nums);
		
		System.out.println(indx);

	}

}
