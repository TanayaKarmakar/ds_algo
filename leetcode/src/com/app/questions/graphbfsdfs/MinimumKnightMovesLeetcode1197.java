package com.app.questions.graphbfsdfs;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumKnightMovesLeetcode1197 {
	private static final int[][] directions = { { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 }, { 1, 2 }, { 1, -2 },
			{ -1, 2 }, { -1, -2 } };

	private static int minKnightMoves(int x, int y) {
		if (x == 1 && y == 1)
			return 2;
		int nMoves = 0;
		Queue<int[]> q = new LinkedList<>();
		boolean visited[][] = new boolean[301][301];

		x = Math.abs(x);
		y = Math.abs(y);

		q.add(new int[] { 0, 0 });
		visited[0][0] = true;

		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				int[] p = q.poll();

				if (p[0] == x && p[1] == y)
					return nMoves;

				for (int j = 0; j < directions.length; j++) {
					int newX = p[0] + directions[j][0];
					int newY = p[1] + directions[j][1];
					if (newX < 0 || newX > 300 || newY < 0 || newY > 300)
						continue;

					if (!visited[newX][newY]) {
						q.add(new int[] { newX, newY });
						visited[newX][newY] = true;
					}
				}
			}
			nMoves++;
		}
		return -1;
	}

	public static void main(String[] args) {
		int x = 2;
		int y = 1;

		int ans = minKnightMoves(x, y);
		System.out.println(ans);

		x = 1;
		y = 1;

		ans = minKnightMoves(x, y);
		System.out.println(ans);
	}

}
