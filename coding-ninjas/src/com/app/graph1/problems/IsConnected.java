package com.app.graph1.problems;

import java.util.Scanner;

public class IsConnected {
	private static void traverse(int[][] edges, boolean[] visited, int sv, int v) {
		visited[sv] = true;
		for(int i = 0; i < v; i++) {
			if(i == sv)
				continue;
			if(edges[sv][i] == 1 && !visited[i]) {
				traverse(edges, visited, i, v);
			}
		}
	}
	
	private static boolean isConnected(int[][] edges, int v) {
		boolean[] visited = new boolean[v];
		traverse(edges, visited, 0, v);
		
		for(int i = 0; i < v; i++) {
			if(!visited[i])
				return false;
		}
		return true;
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

		boolean isConnected = isConnected(edges, v);
		System.out.println(isConnected);
		
		scanner.close();
		
	}

}
