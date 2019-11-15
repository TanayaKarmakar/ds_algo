package com.app.array.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leaders {
	private static List<Integer> findLeaders(int[] arr, int n) {
		ArrayList<Integer> result = new ArrayList<>();
		

		result.add(arr[n - 1]);
		int i = n - 2;
		int max = arr[n - 1];
		while (i >= 0) {
			if (arr[i] >= max) {
				max = arr[i];
				result.add(max);
			}
			i--;
		}
		Collections.reverse(result);
		return result;
	}

	public static void main(String[] args) {
		List<Integer> result = findLeaders(new int[] { 16, 17, 4, 3, 5, 2 }, 6);
		System.out.println(result);

		result = findLeaders(new int[] { 1, 2, 3, 4, 0 }, 5);
		System.out.println(result);

		result = findLeaders(new int[] { 7, 4, 5, 7, 3 }, 5);
		System.out.println(result);

		result = findLeaders(new int[] { 4, 1, 4 }, 3);
		System.out.println(result);
	}

}
