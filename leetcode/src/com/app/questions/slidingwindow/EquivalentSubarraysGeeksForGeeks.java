package com.app.questions.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class EquivalentSubarraysGeeksForGeeks {
	private static int cnt = 0;
	private static void countRec(int[] nums, int start, int end, int count) {
		if(start >= nums.length || end < 0 || (end - start + 1) < count)
			return;
		Set<Integer> set = new HashSet<>();
		for(int i = start; i <= end; i++) {
			set.add(nums[i]);
		}
		if(set.size() == count) {
			cnt++;
		}
		
		countRec(nums, start + 1, end, count);
		countRec(nums, start, end - 1, count);
		countRec(nums, start + 1, end - 1, count);
	}
	
	private static int countSubarray(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for(int num: nums) {
			set.add(num);
		}
		cnt = 0;
		int count = set.size();
		countRec(nums, 0, nums.length - 1, count);
		return cnt;
	}

	public static void main(String[] args) {
		int[] nums = {2, 1, 3, 2, 3};
		System.out.println(countSubarray(nums));
		
		nums = new int[] {2, 4, 5, 2, 1};
		System.out.println(countSubarray(nums));
		
		nums = new int[] {2, 4, 4, 2, 4};
		System.out.println(countSubarray(nums));
	}

}
