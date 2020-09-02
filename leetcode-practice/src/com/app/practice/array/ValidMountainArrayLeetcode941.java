package com.app.practice.array;

public class ValidMountainArrayLeetcode941 {
	private static boolean validMountainArray(int[] A) {
		int n = A.length;

		for (int i = 1; i < (n - 1); i++) {
			if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
				for (int j = 1; j < i; j++) {
					if (A[j] <= A[j - 1])
						return false;
				}

				for (int j = i + 2; j < n; j++) {
					if (A[j] >= A[j - 1])
						return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 2, 3, 4, 5, 2, 1, 0 };
		
		System.out.println(validMountainArray(nums));
		
		nums = new int[] {0, 2, 3, 3, 5, 2, 1, 0};
		
		System.out.println(validMountainArray(nums));

	}

}
