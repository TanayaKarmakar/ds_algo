package com.app.advancedgraph.problems;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class KingdomOfBananas {
	private static long count = 0;

	private static void dfs(LinkedList<Integer>[] edges, int start, long[] bananas, 
			boolean[] visited) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(start);
		
		while(!stack.isEmpty()) {
			int node = stack.pop();
			if(!visited[node]) {
				visited[node] = true;
				count += bananas[node];
			}
			
			LinkedList<Integer> nodes = edges[node];
			for(Integer el: nodes) {
				if(!visited[el])
					stack.push(el);
			}
		}
	}

	private static long getMaxBanana(LinkedList<Integer>[] edges, long[] bananas, int nV) {
		boolean[] visited = new boolean[nV];
		long maxCount = Long.MIN_VALUE;
		for (int i = 0; i < nV; i++) {
			if (!visited[i]) {
				count = 0;
				dfs(edges, i, bananas, visited);
				maxCount = Long.max(count, maxCount);
			}
		}
		return maxCount;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCase = scanner.nextInt();
		while (nTestCase-- > 0) {
			int nV = scanner.nextInt();
			int nE = scanner.nextInt();
			LinkedList<Integer>[] edges = new LinkedList[nV];
			for (int i = 0; i < nV; i++) {
				edges[i] = new LinkedList<Integer>();
			}

			long[] bananas = new long[nV];

			for (int i = 0; i < nE; i++) {
				int v1 = scanner.nextInt();
				int v2 = scanner.nextInt();
				edges[v1 - 1].add(v2 - 1);
				edges[v2 - 1].add(v1 - 1);
			}

			for (int i = 0; i < nV; i++) {
				bananas[i] = scanner.nextLong();
			}

			long maxBanana = getMaxBanana(edges, bananas, nV);

			System.out.println(maxBanana);
		}
		scanner.close();
	}
}
