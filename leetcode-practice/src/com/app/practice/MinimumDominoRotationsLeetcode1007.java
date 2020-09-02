package com.app.practice;

class Majority {
	int el;
	int majCount;
}

public class MinimumDominoRotationsLeetcode1007 {
	private static Majority findMajorityElement(int[] nums) {
		int mIndx = 0;
		int count = 1;

		int n = nums.length;
		for (int i = 1; i < n; i++) {
			if (nums[i] == nums[mIndx])
				count++;
			else {
				count--;
				if (count == 0) {
					mIndx = i;
					count = 1;
				}
			}
		}

		count = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] == nums[mIndx])
				count++;
		}

		Majority mEl = new Majority();
		if (count > n / 2) {
			mEl.el = nums[mIndx];
			mEl.majCount = count;
		} else {
			mEl.el = -1;
			mEl.majCount = -1;
		}
		return mEl;
	}

	private static int minimumDominoRotations(int[] A, int[] B) {
		Majority aMajority = findMajorityElement(A);
		Majority bMajority = findMajorityElement(B);

		int count = 0;
		int n = A.length;

		int mEl = 0;
		int majCount = 0;

		if (aMajority.majCount > bMajority.majCount) {
			mEl = aMajority.el;
			majCount = aMajority.majCount;
			for (int i = 0; i < n; i++) {
				if (A[i] != mEl && B[i] == mEl)
					count++;
			}
		} else {
			mEl = bMajority.el;
			majCount = bMajority.majCount;
			for (int i = 0; i < n; i++) {
				if (B[i] != mEl && A[i] == mEl)
					count++;
			}
		}

		return majCount + count == n ? count : -1;
	}

	public static void main(String[] args) {
		int[] A = { 2, 1, 2, 4, 2, 2 };
		int[] B = { 5, 2, 6, 2, 3, 2 };

		int count = minimumDominoRotations(A, B);

		System.out.println(count);

		A = new int[] { 3, 5, 1, 2, 3 };
		B = new int[] { 3, 6, 3, 3, 4 };
		
		count = minimumDominoRotations(A, B);

		System.out.println(count);

	}

}
