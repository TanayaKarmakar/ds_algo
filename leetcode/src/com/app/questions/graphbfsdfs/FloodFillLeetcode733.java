package com.app.questions.graphbfsdfs;

public class FloodFillLeetcode733 {
	private static final int[] rDir = { -1, 1, 0, 0 };
	private static final int[] cDir = { 0, 0, -1, 1 };
	private static int startPixelColor = 0;

	private static void dfs(int[][] image, int i, int j, 
			int newColor, boolean[][] visited) {
		if (i < 0 || i >= image.length || j < 0 
				|| j >= image[0].length 
				|| image[i][j] != startPixelColor
				|| visited[i][j] == true)
			return;
		image[i][j] = newColor;
		visited[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int newRow = i + rDir[k];
			int newCol = j + cDir[k];
			dfs(image, newRow, newCol, newColor, visited);
		}
	}

	private static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		startPixelColor = image[sr][sc];
		boolean[][] visited = new boolean[image.length][image[0].length];
		dfs(image, sr, sc, newColor, visited);
		return image;
	}

	public static void main(String[] args) {
//		int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
//		int sr = 1;
//		int sc = 1;
//		int newColor = 2;
		
		int[][] image = {{0,0,0},{0,1,1}};
		int sr = 1;
		int sc = 1;
		int newColor = 1;
		
		floodFill(image, sr, sc, newColor);
		
		for(int i = 0; i < image.length; i++) {
			for(int j = 0; j < image[0].length; j++) {
				System.out.print(image[i][j] + " ");
			}
			System.out.println();
		}
	}

}
