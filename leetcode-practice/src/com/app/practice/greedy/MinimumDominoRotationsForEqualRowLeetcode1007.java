package com.app.practice.greedy;

class Majority {
	int el;
	int count;

	public Majority(int el, int count) {
		this.el = el;
		this.count = count;
	}
}

public class MinimumDominoRotationsForEqualRowLeetcode1007 {
	private static Majority findMajority(int[] nums) {
		int n = nums.length;
		int majEl = nums[0];
		int majIndx = 0;
		int count = 1;

		for (int i = 1; i < n; i++) {
			if (nums[i] == majEl) {
				count++;
			} else {
				count--;
				if (count == 0) {
					majEl = nums[i];
					majIndx = i;
					count = 1;
				}
			}
		}
		
		count = 0;
		for(int i = 0; i < n; i++) {
			if(nums[i] == majEl)
				count++;
		}

		Majority maj;
		if (count > n / 2) {
			maj = new Majority(majEl, count);
		} else {
			maj = new Majority(-1, -1);
		}
		return maj;
	}

	private static int minDominoRotations(int[] A, int[] B) {
		Majority majA = findMajority(A);
		Majority majB = findMajority(B);
		int n = A.length;
		int count = 0;
		if (majA.count == -1 && majB.count == -1)
			return -1;
		int majCount = 0;
		if (majA.count > majB.count) {
			majCount = majA.count;
			for (int i = 0; i < n; i++) {
				if (A[i] != majA.el && B[i] == majA.el)
					count++;
			}
		} else {
			majCount = majB.count;
			for (int i = 0; i < n; i++) {
				if (A[i] == majB.el && B[i] != majB.el)
					count++;
			}
		}

		return (majCount + count) == n ? count : -1;
	}

	public static void main(String[] args) {
		int[] A = { 2, 1, 2, 4, 2, 2 };
		int[] B = { 5, 2, 6, 2, 3, 2 };
		
		int count = minDominoRotations(A, B);
		System.out.println(count);
	}

}
