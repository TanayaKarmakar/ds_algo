package com.app.augustchallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalsTriangleII {
	private static List<Integer> getRow(int rowIndx) {
		int col = 2 * rowIndx + 1;
		int row = rowIndx + 1;
		int[][] dp = new int[row][col];
		
		dp[0][rowIndx] = 1;
		
		for(int i = 1; i < row; i++) {
			for(int j = 0; j < col; j++) {
				int val1 = 0;
				int val2 = 0;
				if(j - 1 >= 0) {
					val1 = dp[i - 1][j - 1];
				}
				if(j + 1 < col) {
					val2 = dp[i - 1][j + 1];
				}
				dp[i][j] = val1 + val2;
			}
		}
		
		List<Integer> res = new ArrayList<>();
		for(int i = 0; i < col; i++) {
			if(dp[row - 1][i] != 0)
				res.add(dp[row - 1][i]);
		}
		
		return res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		List<Integer> ans = getRow(n);
		
		System.out.println(ans);
		
		scanner.close();

	}

}
