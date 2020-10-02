package com.app.practice.array;

public class RemoveDuplicatesFromSortedArrayIILeetcode {
	private static int removeDuplicates(int[] nums) {
		if (nums.length <= 2)
			return nums.length;
		int n = nums.length;
		int i = 0;
		
		while (i < n) {
			int j = i + 1;
			int count = 1;
			while (j < n && nums[i] == nums[j]) {
				count++;
				j++;
			}
			if(count > 2) {
				int k = i + 2;
				while(k < j) {
					nums[k++] = Integer.MAX_VALUE;
				}
			}
			i = j;
		}
		
		
		i = -1;
		for(int j = 0; j < n; j++) {
			if(nums[j] != Integer.MAX_VALUE) {
				i++;
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
			}
		}
		
		return (i + 1);
	}

	public static void main(String[] args) {
		int[] nums = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };

		int ans = removeDuplicates(nums);

		System.out.println(ans);

		nums = new int[] { 1, 1, 1, 2, 2, 3 };

		ans = removeDuplicates(nums);

		System.out.println(ans);

		nums = new int[] { 1, 2, 3, 4, 5 };
		
		ans = removeDuplicates(nums);

		System.out.println(ans);

	}

}
