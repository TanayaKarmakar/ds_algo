package com.app.hashing.practice;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class RelativeSorting {
	private static String relativeSorting(int[] arr1, int[] arr2) {
		int n = arr1.length;

		Map<Integer, Integer> numMap = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			if (!numMap.containsKey(arr1[i])) {
				numMap.put(arr1[i], 1);
			} else {
				int tmp = numMap.get(arr1[i]);
				numMap.put(arr1[i], ++tmp);
			}
		}

		int m = arr2.length;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			if (numMap.containsKey(arr2[i])) {
				int tmp = numMap.get(arr2[i]);
				while (tmp != 0) {
					sb.append(arr2[i] + " ");
					tmp--;
				}
				numMap.remove(arr2[i]);
			}
		}

		for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
			int tmp = entry.getValue();
			while (tmp != 0) {
				sb.append(entry.getKey() + " ");
				tmp--;
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
//		int[] arr1 = { 2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8 };
//		int[] arr2 = { 2, 1, 8, 3 };
//		System.out.println("Relative Sorting - " + relativeSorting(arr1, arr2));
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		StringBuilder sb = new StringBuilder();
		while (nTestCases > 0) {
			int nDim1 = scanner.nextInt();
			int nDim2 = scanner.nextInt();

			int[] arr1 = new int[nDim1];
			int[] arr2 = new int[nDim2];

			for (int i = 0; i < nDim1; i++) {
				arr1[i] = scanner.nextInt();
			}

			for (int i = 0; i < nDim2; i++) {
				arr2[i] = scanner.nextInt();
			}

			sb.append(relativeSorting(arr1, arr2) + "\n");
			nTestCases--;
		}
		
		System.out.print(sb.toString());
		scanner.close();

	}

}
