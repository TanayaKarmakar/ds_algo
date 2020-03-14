package com.app.searchsort.problems;

import java.util.Arrays;
import java.util.Scanner;

public class DistributeCandies {
	private static boolean isArrangementPossible(int[] nums, int k, int nCandies, int nDim) {
		int count = 0;
		for(int i = 0; i < nDim; i++) {
			if(nums[i] >= nCandies) {
				count += (nums[i] / nCandies);
				if(count >= k)
					return true;
			}
		}
		return false;
	}
	
	private static int findMaxCandiesPossible(int[] nums, int k, int nDim) {
		Arrays.sort(nums);
		int min = 0;
		int max = nums[nDim - 1];
		int val = Integer.MIN_VALUE;
		while(min <= max) {
			int mid = min + (max - min)/2;
			if(mid == 0)
				return 0;
			boolean isPossible = isArrangementPossible(nums, k, mid, nDim);
			if(isPossible) {
				val = Integer.max(val, mid);
				min = mid + 1;
				//val = min;
			} else {
				max = mid - 1;
				//val = max;
			}
		}
		return val;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();

		while (nTestCases > 0) {
			int nDim = scanner.nextInt();
			int k = scanner.nextInt();
			int[] boxes = new int[nDim];

			for (int i = 0; i < nDim; i++) {
				boxes[i] = scanner.nextInt();
			}
			
			int maxCandies = findMaxCandiesPossible(boxes, k, nDim);
			
			System.out.println(maxCandies);
			nTestCases--;
		}
		scanner.close();

	}

}
