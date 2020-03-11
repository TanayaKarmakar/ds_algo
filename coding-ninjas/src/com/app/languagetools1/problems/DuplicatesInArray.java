package com.app.languagetools1.problems;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicatesInArray {
	private static int duplicateNumber(int[] nums, int n) {
		Map<Integer, Integer> numMap = new LinkedHashMap<>();
		for(int i = 0;i<n;i++) {
			if(!numMap.containsKey(nums[i])) {
				numMap.put(nums[i], 1);
			} else {
				return nums[i];
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nDim = Integer.parseInt(scanner.nextLine());
		int[] nums = new int[nDim];
		String[] numStr = scanner.nextLine().split("\\s+");

		for (int i = 0; i < nDim; i++) {
			nums[i] = Integer.parseInt(numStr[i]);
		}
		
		System.out.println(duplicateNumber(nums, nDim));
		
		scanner.close();
	}

}
