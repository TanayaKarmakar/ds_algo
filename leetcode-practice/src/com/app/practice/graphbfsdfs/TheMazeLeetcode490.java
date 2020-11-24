package com.app.practice.graphbfsdfs;

public class TheMazeLeetcode490 {
	private static final int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private static boolean isValid(int r, int c, int[][] maze) {
		if (r < 0 || r >= maze.length || c < 0 || c >= maze[0].length)
			return false;
		if (maze[r][c] == 1)
			return false;
		return true;
	}

	private static boolean hasPath(int[][] maze, boolean[][] visited, int r, int c, int dr, int dc) {
		if (r == dr && c == dc)
			return true;
		if (visited[r][c] == true)
			return false;
		visited[r][c] = true;
		
		System.out.println("newRow : " + r + " | newCol : " + c);

		for (int i = 0; i < 4; i++) {
			int newRow = r;
			int newCol = c;

			while (isValid(newRow + directions[i][0], newCol + directions[i][1], maze)) {
				newRow += directions[i][0];
				newCol += directions[i][1];
			}
			
			if (hasPath(maze, visited, newRow, newCol, dr, dc))
				return true;
		}

		return false;
	}

	private static boolean hasPath(int[][] maze, int[] start, int[] destination) {
		int m = maze.length;
		int n = maze[0].length;

		boolean[][] visited = new boolean[m][n];

		int sr = start[0];
		int sc = start[1];

		int dr = destination[0];
		int dc = destination[1];

		boolean hasPath = hasPath(maze, visited, sr, sc, dr, dc);
		return hasPath;
	}

	public static void main(String[] args) {
		int[][] maze = { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 },
				{ 0, 0, 0, 0, 0 } };

		int[] start = { 0, 4 };
		int[] destination = { 4, 4 };
		
		System.out.println(hasPath(maze, start, destination));

	}

}
