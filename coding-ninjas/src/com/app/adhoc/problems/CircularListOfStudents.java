package com.app.adhoc.problems;

import java.util.Scanner;

public class CircularListOfStudents {
	private static final int[] nums = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

	private static int findNumberAtPos(int startPos, int offset) {
		int finalPos = (startPos + offset) % nums.length;
		
		return nums[finalPos];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();

		while (nTestCases > 0) {
			int startPos = scanner.nextInt();
			int offset = scanner.nextInt();
			int ans = findNumberAtPos(startPos, offset);
			System.out.println(ans);
			nTestCases--;
		}

		scanner.close();
	}

}
