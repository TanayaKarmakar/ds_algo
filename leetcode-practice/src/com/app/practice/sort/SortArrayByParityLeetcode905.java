package com.app.practice.sort;

import java.util.Arrays;

public class SortArrayByParityLeetcode905 {
	private static int[] sortArrayByParity(int[] A) {
		if(A.length == 0)
			return A;
		int n = A.length;
		int i = -1;
		for (int j = 0; j < n; j++) {
			if (A[j] % 2 == 0) {
				i++;
				int tmp = A[i];
				A[i] = A[j];
				A[j] = tmp;
			}
		}

		return A;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4 };
		
		System.out.println(Arrays.toString(sortArrayByParity(A)));

	}

}
