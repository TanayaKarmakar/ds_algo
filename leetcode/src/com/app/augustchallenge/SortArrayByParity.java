package com.app.augustchallenge;

import java.util.Arrays;
import java.util.Scanner;

public class SortArrayByParity {
	private static int[] sortArrayByParity(int[] A) {
		if(A.length <= 1)
			return A;
		int n = A.length;
		
		int[] tmp = new int[n];
		
		int start = 0;
		int end = n - 1;
		
		for(int i = 0; i < n; i++) {
			if(A[i] % 2 == 0) {
				tmp[start++] = A[i];
			} else {
				tmp[end--] = A[i];
			}
		}
		
		return tmp;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int[] nums = new int[n];
		
		for(int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}
		
		nums = sortArrayByParity(nums);
		
		System.out.println(Arrays.toString(nums));
		
		scanner.close();

	}

}
