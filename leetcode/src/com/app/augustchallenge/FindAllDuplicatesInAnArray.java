package com.app.augustchallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindAllDuplicatesInAnArray {
	private static List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			int indx = Math.abs(nums[i]);
			if (nums[indx - 1] > 0) {
				nums[indx - 1] = -nums[indx - 1];
			} else {
				res.add(indx);
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int[] nums = new int[n];
		for(int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}
		
		List<Integer> res = findDuplicates(nums);
		
		System.out.println(res);
		
		scanner.close();
	}

}
