package com.app.questions.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountDistinctElementInEveryWindowGeeksForGeeks {
	private static void countDistinct(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		
		int n = nums.length;
		int l = 0;
		int r = 0;
		
		
		for(r = 0; r < k; r++) {
			map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
		}
		
		while(r < n) {
			System.out.print(map.size() + " ");
			
			int val = map.get(nums[l]);
			if(val == 1)
				map.remove(nums[l]);
			else
				map.put(nums[l], --val);
			
			map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
			r++;
			l++;
		}
		System.out.print(map.size() + "\n");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		
		while(nTestCases-- > 0) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			int[] nums = new int[n];
			for(int i = 0; i < n; i++) {
				nums[i] = scanner.nextInt();
			}
			
			countDistinct(nums, k);
		}
		scanner.close();
	}
}
