package com.app.array.practice;

public class EquilibiriumPoint {
	private static int equilibriumPoint(int[] arr) {
		if (arr.length == 1)
			return 1;
		int sum = 0;
		int leftSum = 0;
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}

		for (int i = 0; i < n; i++) {
			sum -= arr[i];
			if (sum == leftSum)
				return (i + 1);
			leftSum += arr[i];
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Equilibrium Point - " + equilibriumPoint(new int[] { 1 }));
		System.out.println("Equilibrium Point - " + equilibriumPoint(new int[] { 1, 3, 5, 2, 2 }));
	}

}
