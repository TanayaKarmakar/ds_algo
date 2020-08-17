package com.app.questions.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MissingElementInSortedArrayLeetcode1060 {
	private static int missingElement(int[] nums, int k) {
		int size = 10000001;
		int n = nums.length;
		List<Integer> missingEl = new ArrayList<>();
		
		int i = 0;
		
		for(int j = 1; j < n; j++) {
			if((nums[j] - nums[j - 1]) > 1) {
				for(i = nums[j - 1] + 1; i < nums[j]; i++) {
					missingEl.add(i);
				}
			}
		}
		
		for(i = nums[n - 1] + 1; i < size; i++) {
			missingEl.add(i);
		}
		
		int start = 0;
		int end = missingEl.size();
		
		while(start < end) {
			int mid = start + (end - start) /2;
			if(mid == k)
				return missingEl.get(k - 1);
			else if(mid > k) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int[] nums = new int[n];
		
		for(int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}
		
		int k = scanner.nextInt();

		int ans = missingElement(nums, k);
		
		System.out.println(ans);
		scanner.close();
	}

}
