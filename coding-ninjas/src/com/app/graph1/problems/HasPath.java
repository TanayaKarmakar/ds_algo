package com.app.graph1.problems;

import java.util.Scanner;

public class HasPath {
	private static boolean found = false;

	private static boolean hasPath(int[][] edges, boolean[] visited, int start, int end, int v) {
		visited[start] = true;
		for (int i = 0; i < v; i++) {
			if (edges[start][i] == 1) {
				if(i == end) {
					found = true;
					break;
				} 
				if (!visited[i]) {
					hasPath(edges, visited, i, end, v);
				}	
			}
		}
		return found;
	}

	private static boolean hasPath(int[][] edges, int start, int end, int v) {
		boolean[] visited = new boolean[v];
		found = false;
		for (int i = 0; i < v; i++) {
			if (!visited[i] && i == start) {

				boolean hasPath = hasPath(edges, visited, i, end, v);
				if (hasPath)
					return true;

			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int v = scanner.nextInt();
		int e = scanner.nextInt();
		int[][] edges = new int[v][v];

		for (int i = 0; i < e; i++) {
			int v1 = scanner.nextInt();
			int v2 = scanner.nextInt();

			edges[v1][v2] = 1;
			edges[v2][v1] = 1;
		}

		int start = scanner.nextInt();
		int end = scanner.nextInt();

		boolean hasPath = hasPath(edges, start, end, v);
		System.out.println(hasPath);
		scanner.close();
	}

}
