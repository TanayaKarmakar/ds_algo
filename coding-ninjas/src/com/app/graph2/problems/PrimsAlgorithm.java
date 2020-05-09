package com.app.graph2.problems;

import java.util.Arrays;
import java.util.Scanner;

public class PrimsAlgorithm {
	private static int getMinVertex(int[] weight, boolean[] visited, int n) {
		int minVertex = -1;
		for(int i = 0; i < n; i++) {
			if(!visited[i] && (minVertex == -1 || weight[minVertex] > weight[i])) {
				minVertex = i;
			}
		}
		return minVertex;
	}
	
	private static void getMST(int[][] edges, int nV, int nE) {
		int[] weight = new int[nV];
		boolean[] visited = new boolean[nV];
		int[] parent = new int[nV];
		
		Arrays.fill(weight, Integer.MAX_VALUE);
		parent[0] = -1;
		weight[0] = 0;
		int i = 0;
		while(i < nV - 1) {
			int minVertex = getMinVertex(weight, visited, nV);
			visited[minVertex] = true;
			for(int j = 0; j < nV; j++) {
				if(edges[minVertex][j] != 0 && !visited[j]) {
					if(weight[j] > edges[minVertex][j]) {
						weight[j] = edges[minVertex][j];
						parent[j] = minVertex;
					}
				}
			}
			
			i++;
		}
		
		for(i = 1; i < nV; i++) {
			int v1 = Integer.min(i, parent[i]);
			int v2 = Integer.max(i, parent[i]);
			System.out.println(v1 + " " + v2 + " " + weight[i]);
		}
		
	}
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nV = scanner.nextInt();
		int nE = scanner.nextInt();
		int[][] edges = new int[nV][nV];
		
		int i = 0;
		while(i < nE) {
			int v1 = scanner.nextInt();
			int v2 = scanner.nextInt();
			int w = scanner.nextInt();
			edges[v1][v2] = w;
			edges[v2][v1] = w;
			i++;
		}
		
		getMST(edges, nV, nE);
		
		scanner.close();
	}

}
