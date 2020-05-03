package com.app.mock.google.set1;

public class ValidMountainArray {
	private static boolean validMountainArray(int[] A) {
		if (A.length < 3)
			return false;
		int n = A.length;
		for (int i = 1; i < n - 1; i++) {
			if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
				for (int j = 1; j < i; j++) {
					if (A[j] <= A[j - 1])
						return false;
				}

				for (int j = i + 2; j < n; j++) {
					if (A[j - 1] <= A[j])
						return false;
				}
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 1 };

		System.out.println(validMountainArray(nums));

		nums = new int[] { 3, 5, 5 };

		System.out.println(validMountainArray(nums));
		
		nums = new int[] {0, 3, 2, 1};
		
		System.out.println(validMountainArray(nums));
	}

}
