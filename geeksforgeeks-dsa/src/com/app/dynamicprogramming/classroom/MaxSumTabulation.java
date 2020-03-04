package com.app.dynamicprogramming.classroom;

public class MaxSumTabulation {
	private static int maxSum(int[] arr, int n) {
		if(n == 1)
			return arr[0];
		int[] table = new int[n + 1];
		table[0] = 0;
		table[1] = arr[0];
		table[2] = Integer.max(arr[0], arr[1]);
		for (int i = 3; i <= n; i++) {
			table[i] = Integer.max(table[i - 1], table[i - 2] + arr[i - 1]);
		}
		return table[n];
	}

	public static void main(String[] args) {
		int[] arr = { 10, 5, 15, 20 };
		
		System.out.println("MaxSum - " + maxSum(arr, arr.length));
		
		arr = new int[] {25};
		
		System.out.println("MaxSum - " + maxSum(arr, arr.length));

	}

}
