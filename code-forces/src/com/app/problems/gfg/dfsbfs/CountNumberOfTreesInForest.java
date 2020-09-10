package com.app.problems.gfg.dfsbfs;

import java.util.LinkedList;
import java.util.Scanner;

public class CountNumberOfTreesInForest {
	private static void dfs(LinkedList<Integer>[] edges, int v, boolean[] visited) {
		visited[v] = true;
		LinkedList<Integer> neighbors = edges[v];
		for (Integer nei : neighbors) {
			if (!visited[nei])
				dfs(edges, nei, visited);
		}
	}

	private static int numForest(LinkedList<Integer>[] edges, int n) {
		int count = 0;
		boolean[] visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfs(edges, i, visited);
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int e = scanner.nextInt();

		LinkedList<Integer>[] edges = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			edges[i] = new LinkedList<>();
		}

		for (int i = 0; i < e; i++) {
			int v1 = scanner.nextInt();
			int v2 = scanner.nextInt();
			edges[v1].add(v2);
			edges[v2].add(v1);
		}
		
		int count = numForest(edges, n);
		System.out.println(count);

		scanner.close();
	}

}
