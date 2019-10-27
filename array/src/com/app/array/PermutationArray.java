package com.app.array;

import java.util.Arrays;
import java.util.Random;

//Fisher-Yates algorithm
public class PermutationArray {
	private static void permuteArray(int[] arr) {
		Random rand = new Random();
		int n = arr.length;
		int j = 0;
		for (int i = (n - 1); i >= 0; i--) {
			j = rand.nextInt((i + 1));
			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println("Before permutation");
		System.out.println(Arrays.toString(arr));
		
		permuteArray(arr);
		
		System.out.println("After permutation");
		System.out.println(Arrays.toString(arr));
	}

}
