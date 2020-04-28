package com.app.questions.practice;

class Majority {
	int el;
	int majCount;
}

public class MinimumDominoRotationLeetcode1007 {
	private static Majority findMajority(int[] nums) {
		int count = 1;
		int el = 0;
		int n = nums.length;
		for (int i = 1; i < n; i++) {
			if (nums[el] == nums[i])
				count++;
			else {
				count--;
				if (count == 0) {
					el = i;
					count = 1;
				}
			}
		}

		count = 0;
		for (int i = 0; i < n; i++) {
			if (nums[el] == nums[i])
				count++;
		}

		Majority maj = new Majority();
		if (count > nums.length / 2) {
			maj.majCount = count;
			maj.el = nums[el];
		} else {
			maj.el = -1;
			maj.majCount = -1;
		}
		return maj;
	}

	private static int minRotation(int[] A, int[] B) {
		Majority majA = findMajority(A);
		Majority majB = findMajority(B);

		if(majA.majCount == -1 && majB.majCount == -1)
			return -1;
		int majCount = 0;
		int count = 0;
		int n = A.length;
		int el = 0;
		if(majA.majCount > majB.majCount) {
			majCount = majA.majCount;
			el = majA.el;
			for(int i = 0; i < n; i++) {
				if(A[i] != el && B[i] == el)
					count++;
			}
		} else {
			majCount = majB.majCount;
			el = majB.el;
			for(int i = 0; i < n; i++) {
				if(B[i] != el && A[i] == el)
					count++;
			}
		}
		return (majCount + count == n) ? count: -1;
	}

	public static void main(String[] args) {
		// TC1
		int[] A = { 2, 1, 2, 4, 2, 2 };
		int[] B = { 5, 2, 6, 2, 3, 2 };

		int minCount = minRotation(A, B);

		System.out.println(minCount);

		A = new int[] { 3, 5, 1, 2, 3 };
		B = new int[] { 3, 6, 3, 3, 4 };

		minCount = minRotation(A, B);

		System.out.println(minCount);

		A = new int[] { 1, 2, 1, 1, 1, 2, 2, 2 };
		B = new int[] { 2, 1, 2, 2, 2, 2, 2, 2 };

		minCount = minRotation(A, B);

		System.out.println(minCount);

		A = new int[] { 1, 2, 3, 4, 6 };
		B = new int[] { 6, 6, 6, 6, 5 };
		
		minCount = minRotation(A, B);

		System.out.println(minCount);

	}

}
