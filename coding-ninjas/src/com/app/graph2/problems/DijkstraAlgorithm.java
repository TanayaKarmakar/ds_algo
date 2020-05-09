package com.app.graph2.problems;

import java.util.Arrays;
import java.util.Scanner;

public class DijkstraAlgorithm {
	private static int getMinVertex(int[] dist, boolean []visited, int n) {
		int minVertex = -1;
		for(int i = 0; i < n; i++) {
			if(!visited[i] && (minVertex == -1 || dist[minVertex] > dist[i]))
				minVertex = i;
		}
		return minVertex;
	}
	
	private static void getShortestPath(int[][] edges, int nV) {
		int[] dist = new int[nV];
		boolean[] visited = new boolean[nV];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		for(int i = 0; i < nV; i++) {
			int minVertex = getMinVertex(dist, visited, nV);
			visited[minVertex] = true;
			for(int j = 0; j < nV; j++) {
				if(edges[minVertex][j] != 0 && !visited[j]) {
					if(dist[j] > dist[minVertex] + edges[minVertex][j]) {
						dist[j] = dist[minVertex] + edges[minVertex][j];
					}
				}
			}
		}
		
		for(int i = 0; i < nV; i++) {
			System.out.println(i + " " + dist[i]);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nV = scanner.nextInt();
		int nE = scanner.nextInt();
		
		int[][] edges = new int[nV][nV];
		
		for(int i = 0; i < nE; i++) {
			int v1 = scanner.nextInt();
			int v2 = scanner.nextInt();
			int w = scanner.nextInt();
			edges[v1][v2] = w;
			edges[v2][v1] = w;
		}

		getShortestPath(edges, nV);
		scanner.close();
	}

}
