package com.app.problems.hackerearth.bfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

class Point1 {
	int x;
	int y;

	public Point1(int x, int y) {
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
		Point1 other = (Point1) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	public String toString() {
		return x + " " + y;
	}
}

public class ZetaAndThanos {
	private static boolean isSafe(char[][] grid, int i, int j) {
		return (i >= 0 && i < grid.length && j >= 0 
				&& j < grid[0].length && grid[i][j] != '*');
	}
	
	private static int[] getMinValue(int zR, int zC, int tR, int tC, char[][] grid) {
		zR = zR - 1;
		zC = zC - 1;
		tR = tR - 1;
		tC = tC - 1;

		Map<Point1, Point1> map = new HashMap<>();
		Set<Point1> visited = new HashSet<>();
		int count = 0;
		int totalSum = 0;
		Queue<int[]> q = new LinkedList<>();
		int[] rDir = { -1, 1, 0, 0 };
		int[] cDir = { 0, 0, -1, 1 };
		
		q.add(new int[] {zR, zC});
		q.add(null);
		visited.add(new Point1(zR, zC));
		
		boolean found = false;
		
		while(!q.isEmpty()) {
			int[] point = q.poll();
			
			if(point == null) {
				count++;
				if(q.peek() != null)
					q.add(null);
				continue;
			}
			
			if(point[0] == tR && point[1] == tC) {
				found = true;
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int newRow = point[0] + rDir[i];
				int newCol = point[1] + cDir[i];
				if(isSafe(grid, newRow, newCol) && !visited.contains(new Point1(newRow, newCol))) {
					visited.add(new Point1(newRow, newCol));
					Point1 pt1 = new Point1(point[0], point[1]);
					Point1 pt2 = new Point1(newRow, newCol);
					
					map.put(pt2, pt1);
					q.add(new int[] {newRow, newCol});
				}
			}
		}
		if(!found) 
			return new int[] {-1, -1};
		Point1 end = new Point1(tR, tC);
		Point1 start = new Point1(zR, zC);
		
		while(!end.equals(start)) {
			totalSum += (grid[end.x][end.y] - '0');
			end = map.get(end);
		}
		
		totalSum += (grid[end.x][end.y] - '0');
		return new int[] {count, totalSum};
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int r = scanner.nextInt();
		int c = scanner.nextInt();

		char[][] grid = new char[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				grid[i][j] = scanner.next().charAt(0);
			}
		}

		// Zeta's initial position
		int zR = scanner.nextInt();
		int zC = scanner.nextInt();

		int nQueries = scanner.nextInt();

		while (nQueries-- > 0) {
			// Thanos position
			int tR = scanner.nextInt();
			int tC = scanner.nextInt();
			int[] ans = getMinValue(zR, zC, tR, tC, grid);
			System.out.println(ans[0] + " " + ans[1]);
		}

		scanner.close();
	}

}
