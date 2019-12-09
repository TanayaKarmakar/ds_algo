package com.app.array.practice;

import java.util.ArrayList;
import java.util.List;

public class RemoveAdjacentDuplicates {
	private static void removeDups(char[] arr) {
		List<Character> res = new ArrayList<>();
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			if (((i + 1) < n && arr[i] != arr[i + 1]) 
					|| (i == n - 1 && arr[i] != res.get(res.size() - 1))) {
				res.add(arr[i]);
			}
		}

		System.out.println(res);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] arr = { 'a', 'b', 'b', 'b', 'c', 'd', 'a', 'a', 'a', 'a' };
		removeDups(arr);
	}

}
