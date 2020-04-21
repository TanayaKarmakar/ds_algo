package com.app.questions.read;

public class MinimumNumberOfSwapsLeetcode801 {
	private static int minSwaps(int[] A, int[] B) {
		int n = A.length;
		int[] count = new int[n];


		for(int i = n - 1; i > 0; i--) {
			if(A[i] >= A[i - 1] || B[i] >= B[i - 1]) {
				int tmp = A[i];
				A[i] = B[i];
				B[i] = tmp;
				count[i] = (i == n - 1 ? 1 : 1 + count[i + 1]);
			} else {
				count[i] = (i == n - 1 ? 0 : count[i + 1]);
			}
		}

		count[0] = count[1];

		return count[0];
	}

	public static void main(String[] args) {
		int[] A = { 0, 7, 8, 10, 10, 11, 12, 13, 19, 18 };
		int[] B = { 4, 4, 5, 7, 11, 14, 15, 16, 17, 20 };

		int count = minSwaps(A, B);
		System.out.println(count);

		A = new int[] { 1, 3, 5, 4 };
		B = new int[] { 1, 2, 3, 7 };

		count = minSwaps(A, B);

		System.out.println(count);

		A = new int[] { 0, 4, 4, 5, 9 };
		B = new int[] { 0, 1, 6, 8, 10 };
		
		count = minSwaps(A, B);
		
		System.out.println(count);

	}

}
