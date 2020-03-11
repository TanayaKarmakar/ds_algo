package com.app.languagetools1.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TripletSum {
	/*private static List<String> getTwoSums(int[] nums, int startIndx, int sum) {
		int start = startIndx;
		int end = nums.length - 1;
		List<String> res = new ArrayList<>();
		while (start < end) {
			int curr = nums[start] + nums[end];
			if (curr == sum) {
				res.add(nums[start] + " " + nums[end]);
				start++;
				end--;
			} else if (curr > sum)
				end--;
			else
				start++;

		}
		return res;
	}*/

	private static void tripletSum(int[] nums, int sum) {
		Arrays.sort(nums);
		int n = nums.length;
		for(int i = 0;i<n;i++) {
			int left = i + 1;
			int right = n - 1;
			int item = nums[i];
			while(left < right) {
				if(item + nums[left] + nums[right] == sum) {
					System.out.println(item + " " + nums[left] + " " + nums[right]);
					left++;
					right--;
				} else if(item + nums[left] + nums[right] < sum) {
					left++;
				} else {
					right--;
				}
			}
		}
//		Map<Integer, List<String>> tripletSumMap = new LinkedHashMap<>();
//		for (int i = 0; i < nums.length; i++) {
//			List<String> res = getTwoSums(nums, i + 1, sum - nums[i]);
//			if (!res.isEmpty()) {
//				tripletSumMap.put(nums[i], res);
//			}
//		}
//
//		for (Map.Entry<Integer, List<String>> entry : tripletSumMap.entrySet()) {
//			for (String str : entry.getValue()) {
//				System.out.println(entry.getKey() + " " + str);
//			}
//			//System.out.println();
//		}
	}

	public static void main(String[] args) {
		int val = 12;
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };

		tripletSum(nums, val);
	}

}
