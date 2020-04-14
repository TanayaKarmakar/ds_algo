package com.app.questions;

import java.util.Arrays;

public class CountSquareSubmatricesWithOnesLeetcode1277 {
	private static int countSquares(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		
		int[][] dp = new int[m][n];
		int count = 0;
		for(int i = 0; i < n; i++) {
			if(matrix[0][i] == 1) {
				dp[0][i] = 1;
				count++;
			}		
		}
		
		for(int i = 1; i < m; i++) {
			if(matrix[i][0] == 1) {
				dp[i][0] = 1;
				count++;
			}
		}
		
		System.out.println(count);
		
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				if(matrix[i][j] == 1) {
					count++;
					dp[i][j] = 1 + Integer.min(dp[i - 1][j - 1], 
							Integer.min(dp[i - 1][j], dp[i][j - 1]));
					if(dp[i][j] > 1) {
						count += (dp[i][j] - 1);
					}
				}
			}
		}
		
		System.out.println(Arrays.deepToString(dp));
		
		return count;
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 0, 1 }, { 1, 1, 0 }, { 1, 1, 0 } };
		
		int count = countSquares(mat);
		
		System.out.println(count);
		
		

	}

}
