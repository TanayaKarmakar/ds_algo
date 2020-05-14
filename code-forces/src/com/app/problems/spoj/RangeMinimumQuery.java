package com.app.problems.spoj;

import java.util.Scanner;

public class RangeMinimumQuery {
	private static int log2(int n) {
		if (n <= 0)
			throw new IllegalArgumentException();
		return 31 - Integer.numberOfLeadingZeros(n);
	}

	private static int[][] preprocessing(int[] nums, int n) {
		int[][] sparseTable = new int[n][log2(n) + 1];
		for (int i = 0; i < n; i++) {
			sparseTable[i][0] = i;
		}

		for (int j = 1; (1 << j) < n; j++) {
			for (int i = 0; i + (1 << j) < n; i++) {
				int indx1 = sparseTable[i][j - 1];
				int indx2 = sparseTable[i + (1 << (j - 1))][j - 1];
				if (nums[indx1] < nums[indx2]) {
					sparseTable[i][j] = indx1;
				} else {
					sparseTable[i][j] = indx2;
				}
			}
		}

		return sparseTable;
	}
	
	private static int query(int[][] sparseTable, int[] nums, int left, int right) {
		int nElements = (right - left) + 1;
		int k = log2(nElements);
		int indx1 = sparseTable[left][k];
		int indx2 = sparseTable[left + nElements - (1 << k)][k];
		return Integer.min(nums[indx1], nums[indx2]);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] nums = new int[n];

		for (int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}

		int[][] sparseTable = preprocessing(nums, n);
		int q = scanner.nextInt();
		while(q-- > 0) {
			int left = scanner.nextInt();
			int right = scanner.nextInt();
			
			int value = query(sparseTable, nums, left, right);
			
			System.out.println(value);
		}
		scanner.close();
	}

}
