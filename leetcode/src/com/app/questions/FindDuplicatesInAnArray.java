package com.app.questions;

//Floyd's cycle detection(tortoise and hare algorithm)
public class FindDuplicatesInAnArray {
	private static int findDuplicate(int[] nums) {
		int slow = 0;
		int fast = 0;
		while (true) {
			slow = nums[slow];
			fast = nums[nums[fast]];
			if (slow == fast)
				break;
		}

		int ptr1 = 0;
		int ptr2 = slow;
		while (ptr1 != ptr2) {
			ptr1 = nums[ptr1];
			ptr2 = nums[ptr2];
		}

		return ptr1;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 4, 2, 2, 3 };
		System.out.println("Find Duplicate - " + findDuplicate(arr));
	}

}
