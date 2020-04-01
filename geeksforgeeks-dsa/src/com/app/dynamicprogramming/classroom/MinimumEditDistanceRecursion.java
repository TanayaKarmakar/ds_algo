package com.app.dynamicprogramming.classroom;

public class MinimumEditDistanceRecursion {
	private static int findMinDistance(String str1, String str2, int m, int n) {
		if (m == 0)
			return n;
		if (n == 0)
			return m;
		if (str1.charAt(m - 1) == str2.charAt(n - 1))
			return findMinDistance(str1, str2, m - 1, n - 1);
		else
			return 1 + Integer.min(findMinDistance(str1, str2, m, n - 1),
					Integer.min(findMinDistance(str1, str2, m - 1, n), 
							findMinDistance(str1, str2, m - 1, n - 1)));
	}

	public static void main(String[] args) {
		String str1 = "cat";
		String str2 = "cot";
		
		System.out.println("Min Distance - " + findMinDistance(str1, str2, str1.length(), str2.length()));

	}

}
