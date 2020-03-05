package com.app.dynamicprogramming.classroom;

public class MinimumEditDistanceTopDownDP {
	static int[][] memo;
	
	private static void initMemo(int m, int n) {
		memo = new int[m + 1][n + 1];
	}
	
	private static int findMinDistance(String str1, String str2, int m, int n) {
		if(n == 0)
			return m;
		if(m == 0)
			return n;
		if(memo[m][n] == 0) {
			if(str1.charAt(m - 1) == str2.charAt(n - 1)) {
				memo[m][n] = findMinDistance(str1, str2, m - 1, n - 1);
			} else {
				memo[m][n] = 1 + Integer.min(findMinDistance(str1, str2, m, n - 1),
						Integer.min(findMinDistance(str1, str2, m - 1, n), 
								findMinDistance(str1, str2, m - 1, n - 1)));
			}
		}
		return memo[m][n];
	}

	public static void main(String[] args) {
		String str1 = "cat";
		String str2 = "cut";
		
		initMemo(str1.length(), str2.length());
		System.out.println(findMinDistance(str1, str2, str1.length(), str2.length()));

		str1 = "saturday";
		str2 = "sunday";
		
		initMemo(str1.length(), str2.length());
		System.out.println(findMinDistance(str1, str2, str1.length(), str2.length()));
	}

}
