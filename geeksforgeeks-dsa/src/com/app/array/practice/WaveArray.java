package com.app.array.practice;

import java.util.Arrays;

public class WaveArray {
	private static void convertToWave(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i = i + 2) {
			int tmp = arr[i - 1];
			arr[i - 1] = arr[i];
			arr[i] = tmp;
		}

		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		convertToWave(new int[] { 1, 2, 3, 4, 5 });
		convertToWave(new int[] { 2, 4, 7, 8, 9, 10 });
	}

}
