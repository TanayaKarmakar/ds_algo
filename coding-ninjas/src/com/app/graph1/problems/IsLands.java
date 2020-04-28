package com.app.graph1.problems;

import java.util.Scanner;

public class IsLands {
	private static void traverse(int[][] edges, int sv, boolean[] visited, int n) {
		visited[sv] = true;
		for(int i = 0; i < n; i++) {
			if(!visited[i] && edges[sv][i] == 1) {
				traverse(edges, i, visited, n);
			}
		}
	}
	
	private static int solve(int n, int m, int[] U, int[] V) {
		int[][] edges = new int[n][n];
		
		for(int i = 0; i < m; i++) {
			int u = U[i];
			int v = V[i];
			edges[u - 1][v - 1] = 1;
			edges[v - 1][u - 1] = 1;
		}
		
		boolean[] visited = new boolean[n];
		int count = 0;
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				traverse(edges, i, visited, n);
				count++;
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		
		int[] u = new int[m];
		int[] v = new int[m];
		
		for(int i = 0; i < m; i++) {
			u[i] = scanner.nextInt();
		}
		
		for(int i = 0; i < m; i++) {
			v[i] = scanner.nextInt();
		}

		int nIslands = solve(n, m, u, v);
		System.out.println(nIslands);
		scanner.close();
	}

}
