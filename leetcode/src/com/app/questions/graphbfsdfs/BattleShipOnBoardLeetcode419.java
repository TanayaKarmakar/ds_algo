package com.app.questions.graphbfsdfs;

import java.util.LinkedList;
import java.util.Queue;

public class BattleShipOnBoardLeetcode419 {
	private static int countBattleships(char[][] board) {
		int m = board.length;
		int n = board[0].length;
		
		int count = 0;
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(board[i][j] == 'X') {
					if(i - 1 >= 0 && board[i - 1][j] == 'X')
						continue;
					if(j - 1 >= 0 && board[i][j - 1] == 'X')
						continue;
					count++;
				}
			}
		}

		/*Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'X') {
					q.add(new int[] { i, j });
				}
			}
		}

		int count = 0;
		while (!q.isEmpty()) {
			int[] pt = q.poll();

			if (board[pt[0]][pt[1]] == '.')
				continue;
			if (board[pt[0]][pt[1]] == 'X')
				count++;
			int currRow = pt[0];

			while (currRow >= 0 && board[currRow][pt[1]] == 'X') {
				board[currRow][pt[1]] = '.';
				currRow--;
			}

			int nextRow = pt[0] + 1;
			while (nextRow < m && board[nextRow][pt[1]] == 'X') {
				board[nextRow][pt[1]] = '.';
				nextRow++;
			}

			int currCol = pt[1];
			while (currCol >= 0 && board[pt[0]][currCol] == 'X') {
				board[pt[0]][currCol] = '.';
				currCol--;
			}

			int nextCol = pt[1] + 1;
			while (nextCol < n && board[pt[0]][nextCol] == 'X') {
				board[pt[0]][nextCol] = '.';
				nextCol++;
			}
		}*/

		return count;
	}

	public static void main(String[] args) {
		char[][] board = { { 'X', '.', '.', 'X' }, { '.', '.', '.', 'X' }, { '.', '.', '.', 'X' } };

		int count = countBattleships(board);
		
		System.out.println(count);
	}

}
