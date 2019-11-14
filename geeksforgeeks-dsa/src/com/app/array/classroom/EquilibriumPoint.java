package com.app.array.classroom;

public class EquilibriumPoint {
	private static void findEquilibriumPoint(int[] arr) {
		int n = arr.length;
		int leftSum = 0;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}

		for (int i = 0; i < n; i++) {
			sum -= arr[i];
			if (leftSum == sum) {
				System.out.println("Equilibrium point at index - " + i);
			}
			leftSum += arr[i];
		}
	}

	public static void main(String[] args) {
		int[] arr = { -7, 1, 5, 2, -4, 3, 0 };

		System.out.println("TestCase1 ");
		System.out.println("*************************");
		findEquilibriumPoint(arr);

		System.out.println("TestCase2 ");
		System.out.println("**************************");
		arr = new int[] { -7, 1, 5, 2, -4, 3, -7 };
		findEquilibriumPoint(arr);

	}

}
