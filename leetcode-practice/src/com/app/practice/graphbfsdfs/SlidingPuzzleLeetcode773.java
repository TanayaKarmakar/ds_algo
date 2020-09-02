package com.app.practice.graphbfsdfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzleLeetcode773 {
	private static boolean equal(int[][] board1, int[][] board2) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				if (board1[i][j] != board2[i][j])
					return false;
			}
		}
		return true;
	}

	private static int[] getIndex(int[][] board) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == 0) {
					return new int[] { i, j };
				}
			}
		}
		return new int[] { -1, -1 };
	}
	
	private static boolean contains(Set<int[][]> set, int[][] board) {
		for(int[][] current: set) {
			if(equal(current, board))
				return true;
		}
		return false;
	}

	private static int slidingPuzzle(int[][] board) {
		int startX = -1;
		int startY = -1;

		int[] indices = getIndex(board);
		startX = indices[0];
		startY = indices[1];

		int[][] solvedBoard = { { 1, 2, 3 }, { 4, 5, 0 } };

		Queue<int[][]> q = new LinkedList<>();
		q.add(board);
		q.add(null);
		
		Set<int[][]> set = new HashSet<>();
		set.add(board);

		int count = 0;

		int[] rDir = { -1, 1, 0, 0 };
		int[] cDir = { 0, 0, -1, 1 };

		int currentX = -1;
		int currentY = -1;

		while (!q.isEmpty()) {
			int[][] currentBoard = q.poll();
			if (currentBoard == null) {
				count++;
				if (q.peek() != null)
					q.add(null);
				continue;
			}

			indices = getIndex(currentBoard);
			currentX = indices[0];
			currentY = indices[1];

			if (equal(currentBoard, solvedBoard))
				return count;
			for (int i = 0; i < 4; i++) {
				int newRow = currentX + rDir[i];
				int newCol = currentY + cDir[i];

				if (newRow >= 0 && newRow < 2 && newCol >= 0 && newCol < 3) {
					int[][] newBoard = new int[2][3];

					for (int j = 0; j < 2; j++) {
						newBoard[j] = Arrays.copyOf(currentBoard[j], currentBoard[j].length);
					}

					int tmp = newBoard[newRow][newCol];
					newBoard[newRow][newCol] = newBoard[currentX][currentY];
					newBoard[currentX][currentY] = tmp;
					if (!contains(set, newBoard)) {
						q.add(newBoard);
						set.add(newBoard);
						//continue;
					}
					
				}
			}

		}
		return -1;
	}

	public static void main(String[] args) {
		int[][] board = { { 1, 2, 3 }, { 4, 0, 5 } };
		int count = slidingPuzzle(board);
		System.out.println(count);

		board = new int[][] { { 1, 2, 3 }, { 5, 4, 0 } };

		count = slidingPuzzle(board);
		System.out.println(count);

		board = new int[][] { { 4, 1, 2 }, { 5, 0, 3 } };
		count = slidingPuzzle(board);
		System.out.println(count);

		board = new int[][] { { 3, 2, 4 }, { 1, 5, 0 } };

		count = slidingPuzzle(board);
		System.out.println(count);

	}

}
