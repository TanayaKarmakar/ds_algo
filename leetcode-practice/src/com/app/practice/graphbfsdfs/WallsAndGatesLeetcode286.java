package com.app.practice.graphbfsdfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGatesLeetcode286 {
	private static final int[] rDir = { 0, 0, -1, 1 };
	private static final int[] cDir = { -1, 1, 0, 0 };
	private static final int INF = Integer.MAX_VALUE;

	private static void wallsAndGates(int[][] rooms) {
		if (rooms.length == 0)
			return;
		int m = rooms.length;
		int n = rooms[0].length;

		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (rooms[i][j] == 0)
					q.add(new int[] { i, j });
			}
		}

		while (!q.isEmpty()) {
			int[] pos = q.poll();

			for (int i = 0; i < 4; i++) {
				int newRow = pos[0] + rDir[i];
				int newCol = pos[1] + cDir[i];

				if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || rooms[newRow][newCol] != INF)
					continue;
				rooms[newRow][newCol] = rooms[pos[0]][pos[1]] + 1;
				q.add(new int[] { newRow, newCol });
			}
		}
	}

	public static void main(String[] args) {
		int[][] rooms = { { INF, -1, 0, INF }, { INF, INF, INF, -1 }, { INF, -1, INF, -1 }, { 0, -1, INF, INF } };

		wallsAndGates(rooms);

		System.out.println(Arrays.deepToString(rooms));
	}

}
