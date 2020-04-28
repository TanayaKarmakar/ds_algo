package com.app.graph1.problems;

import java.util.Scanner;

public class DFSAdjacencyMatrix {
	private static void print(int[][] edges, int n, int sv, boolean[] visited) {
		System.out.print(sv + " ");
		visited[sv] = true;
		for(int i = 0; i < n; i++) {
			if(i == sv)
				continue;
			if(edges[sv][i] == 1) {
				if(visited[i] == true)
					continue;
				print(edges, n, i, visited);
			}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nVertices = scanner.nextInt();
		
		int[][] edges = new int[nVertices][nVertices];
		
		int nEdges = scanner.nextInt();
		
		for(int i = 0; i < nEdges; i++) {
			int node1 = scanner.nextInt();
			int node2 = scanner.nextInt();
			
			edges[node1][node2] = 1;
			edges[node2][node1] = 1;
		}

		int sv = scanner.nextInt();
		boolean[] visited = new boolean[nVertices];
		print(edges, nVertices, sv, visited);
		System.out.println();
		scanner.close();
	}

}
