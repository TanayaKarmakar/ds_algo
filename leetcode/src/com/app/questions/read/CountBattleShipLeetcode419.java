package com.app.questions.read;

public class CountBattleShipLeetcode419 {
	private static int countBattleShip(char[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		
		int count = 0;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] == '.')
					continue;
				if(i > 0 && grid[i - 1][j] == 'X')
					continue;
				if(j > 0 && grid[i][j - 1] == 'X')
					continue;
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		char[][] grid = {{'X', '.', 'X'},{'.', '.', 'X'},{'.', '.', 'X'}};
		int count = countBattleShip(grid);
		
		System.out.println(count);
	}

}
