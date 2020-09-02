package com.app.practice.map;

import java.util.Scanner;
import java.util.TreeMap;

public class DivideArraySetOfKConsecutiveNumbersLeetcode1296 {
	private static boolean isPossibleDivide(int[] nums, int k) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		while(map.size() > 0) {
			int start = map.firstEntry().getKey();
			for(int i = start; i < (start + k); i++) {
				if(!map.containsKey(i))
					return false;
				else {
					int val = map.get(i);
					if(val == 1) {
						map.remove(i);
					} else {
						map.put(i, val - 1);
					}
				}
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int[] nums = new int[n];

		for (int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}

		int k = scanner.nextInt();
		
		boolean ans = isPossibleDivide(nums, k);
		
		System.out.println(ans);

		scanner.close();
	}

}
