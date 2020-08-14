package com.app.augustchallenge;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RottingOranges {
	private static int[] rDir = { -1, 1, 0, 0 };
	private static int[] cDir = { 0, 0, -1, 1 };

	private static int orangesRotting(int[][] grid) {
		Queue<int[]> q = new LinkedList<>();
		int n = grid.length;
		int m = grid[0].length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 2) {
					q.add(new int[] { i, j });
				}
			}
		}
		q.add(null);

		int timesRemaining = -1;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			if (curr == null) {
				if (q.peek() != null) {
					q.add(null);
				}
				timesRemaining++;
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int newRow = curr[0] + rDir[i];
				int newCol = curr[1] + cDir[i];

				if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= m 
						|| grid[newRow][newCol] == 2 || grid[newRow][newCol] == 0)
					continue;
				grid[newRow][newCol] = 2;
				q.add(new int[] { newRow, newCol });
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(grid[i][j] == 1)
					return -1;
			}
		}
		
		return timesRemaining;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		
		int[][] grid = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				grid[i][j] = scanner.nextInt();
			}
		}
		
		int timesRemaining = orangesRotting(grid);
		
		System.out.println(timesRemaining);
		
		scanner.close();
	}

}
