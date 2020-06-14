package com.app.problems.hackerearth.binarysearch;

import java.util.Scanner;

public class StudentArrangement {		
	private static int getDesiredCount(int n, int[] students, int m, int k) {
		int count = 0;
		int totalCount = 0;
		int[] dp = new int[m];
		
		for(int i = 0; i < n; i++) {
			int row = students[i];
			if(dp[row - 1] < k) {
				dp[row - 1]++;
				totalCount++;
			} else if(dp[row - 1] == k) {
				if(totalCount == m * k) {
					count += (n - i);
					break;
				}
				int start = row % m; 
				while(start < m && dp[start] == k)
					start++;
				dp[start]++;
				count++;
				totalCount++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int k = scanner.nextInt();
		
		int[] students = new int[n];
		
		for(int i = 0; i < n; i++) {
			students[i] = scanner.nextInt();
		}
		
		int count = getDesiredCount(n, students, m, k);
		
		System.out.println(count);

		scanner.close();
	}

}
