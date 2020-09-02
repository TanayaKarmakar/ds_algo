package com.app.practice.graphbfsdfs;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGatesLeetcode286 {
	private static int[] rDir = { -1, 1, 0, 0 };
	private static int[] cDir = { 0, 0, -1, 1 };
	private static final int INF = Integer.MAX_VALUE;

	private static void wallsAndGates(int[][] rooms) {
		Queue<int[]> q = new LinkedList<>();

		int m = rooms.length;
		int n = rooms[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (rooms[i][j] == 0) {
					q.add(new int[] { i, j });
				}
			}
		}

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			for (int i = 0; i < 4; i++) {
				int newRow = curr[0] + rDir[i];
				int newCol = curr[1] + cDir[i];

				if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || rooms[newRow][newCol] == -1
						|| rooms[newRow][newCol] != INF) {
					continue;
				}
				rooms[newRow][newCol] = rooms[curr[0]][curr[1]] + 1;
				q.add(new int[] { newRow, newCol });
			}
		}
	}

	public static void main(String[] args) {
		int[][] rooms = { { INF, -1, 0, INF }, { INF, INF, INF, -1 }, 
				{ INF, -1, INF, -1 }, { 0, -1, INF, INF } };
		
		wallsAndGates(rooms);
		
		for(int i = 0; i < rooms.length; i++) {
			for(int j = 0; j < rooms[0].length; j++) {
				System.out.print(rooms[i][j] + " ");
			}
			System.out.println();
		}
	}

}
