package com.app.graph1.problems;

import java.util.Scanner;

public class ConnectingDots {
	private static int l = 0;
	
	
	private static void containsCycle1(char[][] grid, int n, int m, int i, int j, char ch, int t, int[][] dots) {
		if(i < 0 || i >= n || j < 0 || j >= m)
			return;
		if(grid[i][j] != ch)
			return;
		if(dots[i][j] != 0) {
			if(dots[i][j] - t + 1>= 4)
				l++;
			return;
		}
		if(l > 0)
			return;
		t++;
		dots[i][j] = t;
		containsCycle1(grid, n, m, i + 1, j, ch, t, dots);
		containsCycle1(grid, n, m, i, j + 1, ch, t, dots);
		containsCycle1(grid, n, m, i - 1, j, ch, t, dots);
		containsCycle1(grid, n, m, i, j - 1, ch, t, dots);
	}
	
	private static int containsCycle(String[] board, int n, int m) {
		char[][] grid = new char[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				grid[i][j] = board[i].charAt(j);
			}
		}
		
		int[][] dots = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m && l == 0; j++) {
				if(dots[i][j] == 0) {
					containsCycle1(grid, n, m, i, j, grid[i][j], 0, dots);
				}
				if(l > 0)
					break;
			}
		}
		return l > 0 ? 1: 0;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		
		String[] board = new String[n];
		for(int i = 0; i < n; i++) {
			board[i] = scanner.next();
		}
		
		int hasCycle = containsCycle(board, n, m);
		
		System.out.println(hasCycle);

		scanner.close();
	}

}
