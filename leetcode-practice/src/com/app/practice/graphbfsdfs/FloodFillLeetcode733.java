package com.app.practice.graphbfsdfs;

import java.util.Arrays;

public class FloodFillLeetcode733 {
	private static final int[] rDir = { -1, 1, 0, 0 };
	private static final int[] cDir = { 0, 0, -1, 1 };

	private static void dfs(int[][] image, boolean[][] visited, int r, int c, int newColor) {
		if (r < 0 || r >= image.length || c < 0 || c >= image[0].length 
				|| image[r][c] == newColor || image[r][c] == 0 || visited[r][c] == true)
			return;
		visited[r][c] = true;
		image[r][c] = newColor;
		for (int i = 0; i < 4; i++) {
			int newRow = r + rDir[i];
			int newCol = c + cDir[i];

			dfs(image, visited, newRow, newCol, newColor);
		}
	}

	private static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		boolean[][] visited = new boolean[image.length][image[0].length];
		dfs(image, visited, sr, sc, newColor);
		return image;
	}

	public static void main(String[] args) {
		int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };

		image = floodFill(image, 1, 1, 2);

		System.out.println(Arrays.deepToString(image));
	}

}
