package com.app.graph1.problems;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Point {
	int row;
	int col;
	
	public Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + row;
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
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}
}

public class CodingNinjas {
	private static final String str = "CODINGNINJA";
	
	private static boolean isSafe(int i, int j, int N, int M) {
		return i >= 0 && i < N && j >= 0 && j < M;
	}
	
	private static boolean containsPath(char[][] grid, Set<Point> visited, int start, int N, int M, int i, int j) {
		if(start == str.length())
			return true;
		Point point = new Point(i, j);
		visited.add(point);
		
		int sRow = i - 1;
		int eRow = i + 1;
		int sCol = j - 1;
		int eCol = j + 1;
		for(int r = sRow; r <= eRow; r++) {
			for(int c = sCol; c <= eCol; c++) {
				if(isSafe(r, c, N, M)) {
					if(!visited.contains(new Point(r, c)) && grid[r][c] == str.charAt(start)) {
						boolean hasPath = containsPath(grid, visited, start + 1, N, M, r, c);
						if(hasPath)
							return true;
						visited.remove(new Point(r, c));
					}
				}
			}
		}
		return false;
	}
	
	private static boolean solve(String[] Graph, int N, int M) {
		char[][] grid = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = Graph[i];
			for(int j = 0; j < M; j++) {
				grid[i][j] = str.charAt(j);
			}
		}
		
		int start = 0;
		Set<Point> visited = new HashSet<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(str.charAt(start) == grid[i][j]) {
					boolean hasPath = containsPath(grid, visited, start + 1, N, M, i, j);
					if(hasPath)
						return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		String[] graph = new String[n];
		
		for(int i = 0; i < n; i++) {
			graph[i] = scanner.next();
		}
		
		boolean solved = solve(graph, n, m);
		if(solved) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
		
		scanner.close();

	}

}
