package com.app.practice.graphbfsdfs;

import java.util.Arrays;

public class FloodFillLeetcode733 {
    private static void dfs(int[][] image, boolean[][] visited, int sr, int sc, int startPixelColor, int newColor) {
        if(sr >= image.length || sc >= image[0].length || sr < 0
                || sc < 0 || image[sr][sc] != startPixelColor || visited[sr][sc])
            return;
        image[sr][sc] = newColor;
        visited[sr][sc] = true;
        dfs(image, visited, sr + 1, sc, startPixelColor, newColor);
        dfs(image, visited, sr - 1, sc, startPixelColor, newColor);
        dfs(image, visited, sr, sc + 1, startPixelColor, newColor);
        dfs(image, visited, sr, sc - 1, startPixelColor, newColor);
    }

    private static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        int startPixelColor = image[sr][sc];
        dfs(image, visited, sr, sc, startPixelColor, newColor);
        return image;
    }

    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};

        floodFill(image, 1, 1, 2);

        System.out.println(Arrays.deepToString(image));
    }
}
