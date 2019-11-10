package com.app.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoNumbersAddUpToK {
	private static void twoNumbers1(int[] arr, int k) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			int num = k - arr[i];
			if(set.contains(num)) {
				System.out.println("Pair Found - " + num + ", " + arr[i]);
			}
			set.add(arr[i]);
		}
	}

	private static void twoNumbers(int[] arr, int k) {
		if (arr.length <= 0)
			return;
		Arrays.sort(arr);
		int i = 0;
		int j = arr.length - 1;
		boolean numFound = false;
		while (i <= j) {
			if (arr[i] + arr[j] == k) {
				System.out.println("Two numbers are - " + arr[i] + ", " + arr[j]);
				numFound = true;
				break;
			} else {
				if (arr[i] + arr[j] < k)
					i++;
				else
					j--;
			}
		}
		if (!numFound) {
			System.out.println("Such combination is not possible");
		}
	}

	public static void main(String[] args) {
		int[] arr = { 10, 15, 3, 7 };
		twoNumbers(arr, 17);
		twoNumbers(arr, 26);
		twoNumbers(arr, 25);
		
		twoNumbers1(arr, 17);
		twoNumbers1(arr, 26);
		twoNumbers1(arr, 25);

	}

}
