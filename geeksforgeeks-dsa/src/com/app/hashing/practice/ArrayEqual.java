package com.app.hashing.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ArrayEqual {
	private static boolean isArrayEqual(int[] arr1, int[] arr2) {
		if (arr1.length != arr2.length)
			return false;
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr1.length; i++) {
			if (!map.containsKey(arr1[i])) {
				map.put(arr1[i], 1);
			} else {
				int tmp = map.get(arr1[i]);
				map.put(arr1[i], ++tmp);
			}
		}

		for (int i = 0; i < arr2.length; i++) {
			if (!map.containsKey(arr2[i])) {
				return false;
			} else {
				int tmp = map.get(arr2[i]);
				--tmp;
				if (tmp == 0) {
					map.remove(arr2[i]);
				} else {
					map.put(arr2[i], tmp);
				}
			}
		}

		return map.keySet().size() == 0;
	}

	public static void main(String[] args) {
//		int[] arr1 = { 1, 2, 5, 4, 0 };
//		int[] arr2 = { 2, 4, 5, 0, 1 };
//
//		System.out.println("Is Array Equal - " + isArrayEqual(arr1, arr2));
//
//		arr1 = new int[] { 1, 2, 5 };
//		arr2 = new int[] { 2, 4, 15 };
//
//		System.out.println("Is Array Equal - " + isArrayEqual(arr1, arr2));

		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		StringBuilder sb = new StringBuilder();

		while (nTestCases > 0) {
			int nDim = scanner.nextInt();

			int[] arr1 = new int[nDim];
			int[] arr2 = new int[nDim];

			for (int i = 0; i < nDim; i++) {
				arr1[i] = scanner.nextInt();
			}

			for (int i = 0; i < nDim; i++) {
				arr2[i] = scanner.nextInt();
			}
			
			if(isArrayEqual(arr1, arr2)) {
				sb.append(1 + "\n");
			} else {
				sb.append(0 + "\n");
			}
			nTestCases--;
		}
		System.out.print(sb.toString());
		scanner.close();
	}

}
