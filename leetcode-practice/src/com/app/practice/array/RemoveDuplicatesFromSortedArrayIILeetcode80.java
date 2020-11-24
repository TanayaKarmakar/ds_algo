package com.app.practice.array;

public class RemoveDuplicatesFromSortedArrayIILeetcode80 {
	private static int removeDuplicates(int[] nums) {
		int n = nums.length;
		int i = 0;
		
		while(i < n) {
			int count = 1;
			int j = i + 1;
			while(j < n && nums[i] == nums[j]) {
				j++;
				count++;
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
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		
		int len = removeDuplicates(nums);
		
		System.out.println(len);

	}

}
