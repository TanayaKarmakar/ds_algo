package com.app.questions.practice;

import java.util.ArrayList;
import java.util.List;

public class MissingRangesLeetcode163 {
	private static List<String> findMissingRanges(int[] nums, int lower, int upper) {	
		
		List<String> res = new ArrayList<>();
		int n = nums.length;
		if(n == 0) {
			if(lower < upper) {
				res.add(lower + "->" + upper);
			}
			else if(lower == upper) {
				res.add(lower + "");
			}
			return res;
		}
		long currentLower = Integer.MIN_VALUE;
		long currentUpper = Integer.MAX_VALUE;
		long ll = lower;
		long uu = upper;
		if (nums[0] > ll) {
			currentLower = ll;
			if (nums[0] - 1 > ll) {
				currentUpper = nums[0] - 1;
			}
			res.add(currentLower + (currentUpper == Integer.MAX_VALUE ? "": "->" + currentUpper));
		}
		for (int i = 1; i < n; i++) {
			long prev = nums[i - 1];
			long next = nums[i];
			//System.out.println(next - prev);
			if (next - prev > 1) {
				String curr = "";
				currentUpper = next - 1;
				if (prev + 1 != currentUpper) {
					currentLower = prev + 1;
					curr = currentLower + "->";
				}
				curr += currentUpper;
				res.add(curr);
			}
		}
		int last = nums[n - 1];
		if (last < uu) {
			if (last + 1 == uu) {
				res.add(last + 1 + "");
			} else {
				res.add(last + 1 + "->" + uu);
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 3, 50, 75 };
		int lower = 0;
		int upper = 99;
		
		List<String> res = findMissingRanges(nums, lower, upper);
		
		System.out.println(res);

	}

}
