package com.app.graph.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NearestCellHaving1 {
	private static void printDistance(ArrayList<ArrayList<Integer>> mat, int row, int col) {
		int[][] res = new int[row][col];
		for (int i = 0; i < row; i++) {
			int[] curr = res[i];
			Arrays.fill(curr, Integer.MAX_VALUE);
		}

		Queue<Integer[]> q = new LinkedList<>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (mat.get(i).get(j) == 1) {
					res[i][j] = 0;
					q.add(new Integer[] { i, j });
				}
			}
		}

		int[][] dist = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
		while (!q.isEmpty()) {
			Integer[] curr = q.poll();
			for (int i = 0; i < 4; i++) {
				int newR = curr[0] + dist[i][0];
				int newC = curr[1] + dist[i][1];
				if (newR >= 0 && newR < row && newC >= 0 && newC < col) {
					if (res[newR][newC] > res[curr[0]][curr[1]] + 1) {
						res[newR][newC] = res[curr[0]][curr[1]] + 1;
						q.add(new Integer[] { newR, newC });
					}
				}
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(res[i][j] + " ");
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> item = new ArrayList<>();
		item.add(1);
		item.add(0);
		list.add(item);
		
		item = new ArrayList<>();
		item.add(0);
		item.add(1);
		list.add(item);
		
		printDistance(list, 2, 2);
	}

}
