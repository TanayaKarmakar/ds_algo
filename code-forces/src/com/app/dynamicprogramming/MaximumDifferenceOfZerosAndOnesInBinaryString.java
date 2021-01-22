package com.app.dynamicprogramming;

import java.util.Scanner;

public class MaximumDifferenceOfZerosAndOnesInBinaryString {
	private static String maxDiffSubstring(String str) {
		int n = str.length();
		int currentSum = 0;
		int maxSum = 0;

		int currentIndx = -1;
		int indxSoFar = -1;

		for (int i = 0; i < n; i++) {
			if (str.charAt(i) == '0') {
				++currentSum;
			} else {
				--currentSum;
			}
			if (currentSum < 0) {
				currentSum = 0;
				currentIndx = i + 1;
			}

			if (currentSum > maxSum) {
				maxSum = currentSum;
				indxSoFar = currentIndx;
			}
		}
		
		System.out.println("MaxSum - " + maxSum);

		return maxSum == 0? "": str.substring(indxSoFar);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		
		String ans = maxDiffSubstring(str);
		
		System.out.println(ans);
		
		scanner.close();
	}

}
