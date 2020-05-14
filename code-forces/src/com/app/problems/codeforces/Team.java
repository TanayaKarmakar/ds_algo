package com.app.problems.codeforces;

import java.util.Scanner;

public class Team {
	private static int getAns(int[][] grid, int n) {
		int count = 0;
		for(int i = 0; i < n; i++) {
			int currCount = 0;
			for(int j = 0; j < 3; j++) {
				if(grid[i][j] == 1)
					currCount++;
			}
			if(currCount >= 2)
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] grid = new int[n][3];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 3; j++) {
				grid[i][j] = scanner.nextInt();
			}
		}
		
		int ans = getAns(grid, n);
		
		System.out.println(ans);

		scanner.close();
	}

}
