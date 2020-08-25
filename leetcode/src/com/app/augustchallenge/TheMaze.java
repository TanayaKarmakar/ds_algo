package com.app.augustchallenge;

public class TheMaze {
	private static final int[] rDir = { -1, 1, 0, 0 };
	private static final int[] cDir = { 0, 0, -1, 1 };
	
	private static boolean isValid(int row, int col, int[][] maze) {
		if(row < 0 || row >= maze.length)
			return false;
		if(col < 0 || col >= maze[0].length)
			return false;
		if(maze[row][col] == 1)
			return false;
		return true;
	}

	private static boolean hasPath(int[][] maze, boolean[][] visited, int r, int c, int dr, int dc) {
		if (visited[r][c] == true)
			return false;
		if (r == dr && c == dc)
			return true;
		
		visited[r][c] = true;
		for (int k = 0; k < 4; k++) {
			int newRow = r;
			int newCol = c;
			while(isValid(newRow + rDir[k], newCol + cDir[k], maze)) {
				newRow += rDir[k];
				newCol += cDir[k];
			}
		
			if (hasPath(maze, visited, newRow, newCol, dr, dc))
				return true;
		}

		return false;
	}

	private static boolean hasPath(int[][] maze, int[] start, int[] destination) {
		int sr = start[0];
		int sc = start[1];

		int dr = destination[0];
		int dc = destination[1];

		int m = maze.length;
		int n = maze[0].length;

		boolean[][] visited = new boolean[m][n];

		boolean hasPath = hasPath(maze, visited, sr, sc, dr, dc);

		if (hasPath) {
			return true;
		} else {
			return false;
		}

	}

	public static void main(String[] args) {
		int[][] maze = { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 },
				{ 0, 0, 0, 0, 0 } };

		int[] start = { 0, 4 };
		int[] end = { 4, 4 };

		boolean hasPath = hasPath(maze, start, end);

		System.out.println(hasPath);

		maze = new int[][] { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 },
				{ 0, 0, 0, 0, 0 } };

		start = new int[] { 0, 4 };
		end = new int[] { 3, 2 };
		
		hasPath = hasPath(maze, start, end);

		System.out.println(hasPath);

	}

}
