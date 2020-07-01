package com.app.questions.graphbfsdfs;

import java.util.Queue;
import java.util.LinkedList;

public class WallsAndGatesLeetcode286 {
	private static int[] rDir = { -1, 1, 0, 0 };
	private static int[] cDir = { 0, 0, -1, 1 };
	
	private static final int EMPTY = Integer.MAX_VALUE;
	private static final int GATE = 0;
	
	private static void wallsAndGates(int[][] rooms) {
		int m = rooms.length;
		int n = rooms[0].length;
		
		Queue<int[]> q = new LinkedList<>();
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(rooms[i][j] == GATE) {
					q.add(new int[] {i, j});
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] cell = q.poll();
			int row = cell[0];
			int col = cell[1];
			
			for(int i = 0; i < 4; i++) {
				int r = row + rDir[i];
				int c = col + cDir[i];
				
				if(r < 0 || r >= m || c < 0 || c >= n || rooms[r][c] != EMPTY)
					continue;
				rooms[r][c] = rooms[row][col] + 1;
				q.add(new int[] {r, c});
			}
		}
		
	}
	
	public static void main(String[] args) {
		int[][] rooms = {
				{EMPTY, -1, 0, EMPTY}, 
				{EMPTY, EMPTY, EMPTY, -1},
				{EMPTY, -1, EMPTY, -1},
				{0, -1, EMPTY, EMPTY}};
		
		wallsAndGates(rooms);
		
		for(int i = 0; i < rooms.length; i++) {
			for(int j = 0; j < rooms[0].length; j++) {
				System.out.print(rooms[i][j] + " ");
			}
			System.out.println();
		}
	}

}
