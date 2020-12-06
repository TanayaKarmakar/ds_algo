package com.app.array;

public class DeleteAllOccurencesOfAnElement {
	private static int deleteAllOccurences(int[] nums, int target) {
		int n = nums.length;
		int i = -1;

		for (int j = 0; j < n; j++) {
			if (nums[j] != target) {
				i++;
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
			}
		}

		return (i + 1);
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 5, 5, 7, 11, 11, 11, 13 };

		int target = 5;
		int len = deleteAllOccurences(nums, target);

		for (int i = 0; i < len; i++) {
			System.out.print(nums[i] + " ");
		}
		
		System.out.println();
	}

}
