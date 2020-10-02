package com.app.practice.greedy;

class Majority {
	int el;
	int majCount;

	public Majority(int el, int majCount) {
		this.el = el;
		this.majCount = majCount;
	}
}

public class MinimumDominoRotationForEqualRowLeetcode1007 {
	private static Majority findMajorityElement(int[] nums) {
		int n = nums.length;

		int count = 1;
		int mIndx = 0;
		for (int i = 1; i < n; i++) {
			if (nums[mIndx] == nums[i]) {
				count++;
			} else {
				count--;
				if (count == 0) {
					mIndx = i;
					count = 1;
				}
			}
		}

		count = 0;
		for (int i = 0; i < n; i++) {
			if (nums[mIndx] == nums[i])
				count++;
		}

		Majority majority;
		if (count > n / 2) {
			majority = new Majority(nums[mIndx], count);
		} else {
			majority = new Majority(Integer.MAX_VALUE, -1);
		}

		return majority;
	}

	private static int minDominoRotations(int[] A, int[] B) {
		Majority majA = findMajorityElement(A);
		Majority majB = findMajorityElement(B);
		
		if(majA.majCount == -1 && majB.majCount == -1)
			return -1;
		int majCount = 0;
		int el = 0;
		int n = A.length;
		int rotationCount = 0;

		if (majA.majCount > majB.majCount) {
			majCount = majA.majCount;
			el = majA.el;
			for (int i = 0; i < n; i++) {
				if (A[i] != el && B[i] == el)
					rotationCount++;
			}
		} else {
			majCount = majB.majCount;
			el = majB.el;
			for (int i = 0; i < n; i++) {
				if (A[i] == el && B[i] != el)
					rotationCount++;
			}
		} 
		
		if (majCount + rotationCount == n)
			return rotationCount;
		return -1;
	}

	public static void main(String[] args) {
		int[] A = { 2, 1, 2, 4, 2, 2 };
		int[] B = { 5, 2, 6, 2, 3, 2 };

		int ans = minDominoRotations(A, B);

		System.out.println(ans);

		A = new int[] { 3, 5, 1, 2, 3 };
		B = new int[] { 3, 6, 3, 3, 4 };
		
		ans = minDominoRotations(A, B);

		System.out.println(ans);

	}

}
