package com.app.questions.read;

class Majority {
	int count;
	int el;

	public Majority(int count, int el) {
		this.count = count;
		this.el = el;
	}
}

public class MinimumDominoRotationsLeetcode1007 {
	private static Majority findMajority(int[] arr) {
		int n = arr.length;
		int el = arr[0];

		int indx = 0;
		int count = 1;
		for (int i = 1; i < n; i++) {
			if (arr[i] == arr[indx]) {
				count++;
			} else {
				count--;
				if (count == 0) {
					indx = i;
					count = 1;
				}
			}
		}

		count = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == arr[indx]) {
				count++;
			}
		}

		if (count > n / 2)
			return new Majority(count, arr[indx]);
		else
			return new Majority(-1, -1);
	}

	private static int findVal(int[] A, int[] B) {
		Majority aMajority = findMajority(A);
		Majority bMajority = findMajority(B);
//		System.out.println(aMajority.el);
//		System.out.println(bMajority.el);
		if (aMajority.count == -1 && bMajority.count == -1)
			return -1;
		int count = 0;
		int majCount = 0;
		if (aMajority.count > bMajority.count) {
			majCount = aMajority.count;
			for (int i = 0; i < A.length; i++) {
				if (A[i] != aMajority.el && B[i] == aMajority.el) {
					count++;
				}
			}
		} else {
			majCount = bMajority.count;
			for (int i = 0; i < A.length; i++) {
				if (A[i] == bMajority.el && B[i] != bMajority.el) {
					count++;
				}
			}
		}
		System.out.println("Count - " + count);
		return (majCount + count) == A.length ? count: -1;
	}

	public static void main(String[] args) {
		int[] a = { 2, 1, 2, 4, 2, 2 };
		int[] b = { 5, 2, 6, 2, 3, 2 };

		int ans = findVal(a, b);

		System.out.println(ans);

		a = new int[] { 3, 5, 1, 2, 3 };
		b = new int[] { 3, 6, 3, 3, 4 };

		ans = findVal(a, b);

		System.out.println(ans);

		a = new int[] { 1, 2, 1, 1, 1, 2, 2, 2 };
		b = new int[] { 2, 1, 2, 2, 2, 2, 2, 2 };
		
		ans = findVal(a, b);
		
		System.out.println("Ans - " + ans);

	}

}
