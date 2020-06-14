package com.app.problems.hackerearth.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}

public class PrintingPatterns {
	private static boolean isSafe(int i, int j, int r, int c) {
		return (i >= 0 && i < r && j >= 0 && j < c);
	}
	
	private static void printWavePattern(int r, int c, int ci, int cj) {
		int[][] mat = new int[r][c];
		Set<Point> visited = new HashSet<>();
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {ci, cj});
		visited.add(new Point(ci, cj));
		
		while(!q.isEmpty()) {
			int[] point = q.poll();
			
			int rowStart = point[0] - 1;
			int rowEnd = point[0] + 1;
			int colStart = point[1] - 1;
			int colEnd = point[1] + 1;
			
			for(int i = rowStart; i <= rowEnd; i++) {
				for(int j = colStart; j <= colEnd; j++) {
					if(isSafe(i, j, r, c) && !visited.contains(new Point(i, j))) {
						mat[i][j] = 1 + mat[point[0]][point[1]];
						visited.add(new Point(i, j));
						q.add(new int[] {i, j});
					}
				}
			}
		}
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int r = scanner.nextInt();
		int c = scanner.nextInt();
		
		int ci = scanner.nextInt();
		int cj = scanner.nextInt();
		
		printWavePattern(r, c, ci, cj);
		
		scanner.close();
	}

}
