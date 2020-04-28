package com.app.graph1.problems;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Point1 {
	int i;
	int j;
	
	public Point1(int i, int j) {
		this.i = i;
		this.j = j;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		result = prime * result + j;
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
		if (i != other.i)
			return false;
		if (j != other.j)
			return false;
		return true;
	}
}

public class LargestPiece {
	private static int count = 0;
	
	private static void solve1(int n, int[][] grid, Set<Point1> visited, int i, int j) {
		if(i < 0 || i >= n || j < 0 || j >= n)
			return;
		if(grid[i][j] == 0 || visited.contains(new Point1(i, j)))
			return;
		visited.add(new Point1(i, j));
		count++;
		solve1(n, grid, visited, i - 1, j);
		solve1(n, grid, visited, i + 1, j);
		solve1(n, grid, visited, i, j + 1);
		solve1(n, grid, visited, i, j - 1);	
	}
	
	private static int solve(int n, String[] cake) {
		int[][] grid = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				grid[i][j] = cake[i].charAt(j) - '0';
			}
		}
		
		Set<Point1> visited = new HashSet<>();
		int maxCount = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] == 1) {
					count = 0;
					solve1(n, grid, visited, i, j);
					maxCount = Integer.max(count, maxCount);
				}
			}
		}
		
		return maxCount;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String[] cake = new String[n];
		
		for(int i = 0; i < n; i++) {
			cake[i] = scanner.next();
		}

		int count = solve(n, cake);
		
		System.out.println(count);
		scanner.close();
	}

}
