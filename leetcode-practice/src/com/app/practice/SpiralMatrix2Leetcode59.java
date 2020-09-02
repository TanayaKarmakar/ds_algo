package com.app.practice;

public class SpiralMatrix2Leetcode59 {
	private static int[][] generateMatrix(int n) {
		int[][] mat = new int[n][n];
		
		int left = 0;
		int right = n - 1;
		int top = 0;
		int bottom = n - 1;
		
		int num = 1;
		while(left <= right && top <= bottom) {
			for(int i = left; i <= right; i++) {
				mat[top][i] = num++;
			}
			
			top++;
			
			for(int i = top; i <= bottom; i++) {
				mat[i][right] = num++;
			}
			
			right--;
			
			for(int i = right; i >= left; i--) {
				mat[bottom][i] = num++;
			}
			
			bottom--;
			
			for(int i = bottom; i >= top; i--) {
				mat[i][left] = num++;
			}
			left++;
		}
		return mat;
	}

	public static void main(String[] args) {
		int n = 3;
		
		int[][] mat = generateMatrix(n);
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

}
