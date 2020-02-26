package com.app.greedy.practice;

public class LargestNumberWithGivenSum {
	private static String largestNumber(int n, int sum) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		while (sum > 0 && count < n) {
			if (sum > 9) {
				sb.append('9');
				sum -= 9;
			} else {
				sb.append(sum);
				sum = 0;
			}
			count++;
		}

		if (sum > 0 && count == n)
			return "-1";
		while (count < n) {
			sb.append('0');
			count++;
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println("Largest number - " + largestNumber(5, 12));
		System.out.println("Largest number - " + largestNumber(3, 29));
		System.out.println("Largest number - " + largestNumber(3, 26));

	}

}
