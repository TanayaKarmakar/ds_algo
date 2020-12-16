package com.app.sorting;

import java.util.ArrayList;
import java.util.List;

//merge two sorted array provided A has enough space to hold the combined sorted array
public class MergeTwoSortedArray {
	private static void mergeTwoSortedArray(List<Integer> a, List<Integer> b, int m, int n) {
		int setIndx = m + n - 1;
		int i = m - 1;
		int j = n - 1;

		while (i >= 0 && j >= 0) {
			int el = a.get(i) > b.get(j) ? a.get(i--) : b.get(j--);
			a.set(setIndx--, el);
		}

		while (j >= 0) {
			a.set(setIndx--, b.get(j--));
		}
	}

	public static void main(String[] args) {
		List<Integer> a = new ArrayList<>();
		a.add(3);
		a.add(13);
		a.add(17);
		a.add(Integer.MAX_VALUE);
		a.add(Integer.MAX_VALUE);
		a.add(Integer.MAX_VALUE);
		a.add(Integer.MAX_VALUE);
		a.add(Integer.MAX_VALUE);

		List<Integer> b = new ArrayList<>();
		b.add(3);
		b.add(7);
		b.add(11);
		b.add(19);

		int m = 3;
		int n = 4;
		
		mergeTwoSortedArray(a, b, m, n);
		
		int total = m + n;
		for(int i = 0; i < total; i++) {
			System.out.print(a.get(i) + ""
					+ " ");
		}
		
		System.out.println();

	}

}
