package com.app.problems.codeforces;

import java.util.Scanner;

public class BeautifulMatrix {
	private static final int GRID_SIZE = 5;
	
	private static int getMinSwaps(int[][] grid) {
		int row = -1;
		int col = -1;
		for(int i = 0; i < GRID_SIZE; i++) {
			for(int j = 0; j< GRID_SIZE; j++) {
				if(grid[i][j] == 1) {
					row = i;
					col = j;
					break;
				}
			}
		}
		if((row == -1 && col == -1) || (row == GRID_SIZE/2 && col == GRID_SIZE/2))
			return 0;
		else if(row == GRID_SIZE / 2 && col != GRID_SIZE)
			return Math.abs(GRID_SIZE / 2 - col);
		else if(row != GRID_SIZE / 2 && col == GRID_SIZE / 2)
			return Math.abs(GRID_SIZE / 2 - row);
		else
			return Math.abs(GRID_SIZE / 2 - row) + Math.abs(GRID_SIZE / 2 - col);  
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] grid = new int[GRID_SIZE][GRID_SIZE];
		
		for(int i = 0; i < GRID_SIZE; i++) {
			for(int j = 0; j < GRID_SIZE; j++) {
				grid[i][j] = scanner.nextInt();
			}
		}
		
		int minCount = getMinSwaps(grid);
		
		System.out.println(minCount);
		
		scanner.close();

	}

}
