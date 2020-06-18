package com.app.problems.gfg.dp;

import java.util.Scanner;

public class IncreasingSubsequence {
	private static int largestIncreasingSubsequence(String str) {
		int n = str.length();
		int[] lis = new int[n];
		int maxLen = 1;
		lis[0] = 1;
		for(int i = 1; i < n; i++) {
			lis[i] = 1;
			int iVal = (str.charAt(i) - 'a') + 1;
			for(int j = 0; j < i; j++) {
				int jVal = (str.charAt(j) - 'a') + 1;
				if(jVal < iVal) {
					lis[i] = Integer.max(lis[i], lis[j] + 1);
				}
			}
			maxLen = Integer.max(maxLen, lis[i]);
		}
		return maxLen;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int nTestCases = scanner.nextInt();
		while(nTestCases-- > 0) {
			String str = scanner.next();
			int maxLen = largestIncreasingSubsequence(str);
			
			System.out.println(maxLen);
		}
		scanner.close();
	}

}
