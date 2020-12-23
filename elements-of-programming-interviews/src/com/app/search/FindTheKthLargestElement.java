package com.app.search;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class FindTheKthLargestElement {
	private static int findNewPivot(List<Integer> list, int left, int right, int pivotIndx, int k,
			Comparator<Integer> cmp) {
		int newPivotIndx = left;
		int pivotValue = list.get(pivotIndx);
		Collections.swap(list, newPivotIndx, right);
		for (int i = left; i < right; i++) {
			if (cmp.compare(list.get(i), pivotValue) < 0) {
				Collections.swap(list, i, newPivotIndx++);
			}
		}
		Collections.swap(list, right, newPivotIndx);
		return newPivotIndx;
	}

	private static int findKthLargestNumber(List<Integer> list, int k) {
		int left = 0;
		int right = list.size() - 1;

		Comparator<Integer> comparator = (a, b) -> Integer.compare(b, a);

		Random rand = new Random();

		while (left <= right) {
			int rPivotIndx = rand.nextInt(right - left + 1) + left;
			int newPivotIndx = findNewPivot(list, left, right, rPivotIndx, k, comparator);
			if(newPivotIndx == k - 1)
				return list.get(newPivotIndx);
			else if(newPivotIndx > k - 1)
				right = newPivotIndx - 1;
			else
				left = newPivotIndx + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(3,2,1,5,4);
		int k = 4;
		int element = findKthLargestNumber(list, k);
		
		System.out.println(element);
	}

}
