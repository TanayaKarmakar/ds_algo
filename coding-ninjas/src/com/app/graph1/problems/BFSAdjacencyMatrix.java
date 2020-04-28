package com.app.graph1.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSAdjacencyMatrix {
	private static void bfs(int[][] matrix, boolean[] visited, int v, int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		while(!q.isEmpty()) {
			int vert = q.poll();
			System.out.print(vert + " ");
			visited[vert] = true;
			for(int i = 0; i < n; i++) {
				if(i == vert)
					continue;
				if(matrix[vert][i] == 1) {
					if(!visited[i]) {
						q.add(i);
						visited[i] = true;
					}	
				}
			}
		}
	}
	
	private static void print(int[][] matrix, int n, boolean[] visited) {
		for(int i = 0; i < n; i++) {
			if(!visited[i])
				bfs(matrix, visited, i, n);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int e = scanner.nextInt();
		int[][] matrix = new int[n][n];
		for(int i = 0; i < e; i++) {
			int v1 = scanner.nextInt();
			int v2 = scanner.nextInt();
			matrix[v1][v2] = 1;
			matrix[v2][v1] = 1;
		}
		
		boolean[] visited = new boolean[n];
		print(matrix, n, visited);
		System.out.println();
		scanner.close();

	}

}
