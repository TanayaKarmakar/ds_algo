package com.app.problems.gfg.dfsbfs;

import java.util.Scanner;

public class UnitAreaOfLargestRegionsOf1 {
	private static int count = 0;
	
	private static void dfs(int[][] grid, int i, int j, int r, int c) {
		if(i < 0 || i >= r || j < 0 || j >= c || grid[i][j] == 0)
			return;
		count++;
		grid[i][j] = 0;
		for(int i1 = -1; i1 <= 1; i1++) {
			for(int j1 = -1; j1 <= 1; j1++) {
				dfs(grid, i + i1, j + j1, r, c);
			}
		}
	}
	
	private static int largestArea(int[][] grid, int r, int c) {
		int maxCount = 0;
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(grid[i][j] == 1) {
					dfs(grid, i, j, r, c);
					maxCount = Integer.max(maxCount, count);
					count = 0;
				}
			}
		}
		
		return maxCount;
	}
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		
		while(nTestCases-- > 0) {
			int r = scanner.nextInt();
			int c = scanner.nextInt();
			int[][] grid = new int[r][c];
			
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					grid[i][j] = scanner.nextInt();
				}
			}
			
			int maxArea = largestArea(grid, r, c);
			
			System.out.println(maxArea);
		}
		scanner.close();
	}

}
