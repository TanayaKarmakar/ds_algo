package com.app.problems.hackerearth;

public class FindAllSubsequences {
	private static void printSubsequences(String str) {
		int n = str.length();
		int end = (int) Math.pow(2, n) - 1;

		for (int i = 0; i <= end; i++) {
			int number = i;
			for (int j = 0; j < n; j++) {
				int indx = number & (1 << j);
				if (indx != 0) {
					System.out.print(str.charAt(j) + "");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		String str = "abcd";
		printSubsequences(str);
	}

}
