package com.app.advancedgraph.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class PermutationSwaps {
	private static void dfs(LinkedList<Integer>[] edges, int start, boolean[] visited, Set<Integer> component) {
		visited[start] = true;
		component.add(start);
		LinkedList<Integer> nodes = edges[start];
		for (int node : nodes) {
			if (!visited[node]) {
				dfs(edges, node, visited, component);
			}
		}
	}

	private static Set<Set<Integer>> getConnectedComponents(LinkedList<Integer>[] edges, int n) {
		boolean[] visited = new boolean[n];
		Set<Set<Integer>> components = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				Set<Integer> component = new HashSet<>();
				dfs(edges, i, visited, component);
				components.add(component);
			}
		}
		return components;
	}

	private static boolean ifPossible(int[] p, int[] q, LinkedList<Integer>[] edges, int n) {
		Set<Set<Integer>> components = getConnectedComponents(edges, n);
		for(Set<Integer> component: components) {
			Set<Integer> setP = new HashSet<>();
			Set<Integer> setQ = new HashSet<>();
			for(int el: component) {
				setP.add(p[el]);
				setQ.add(q[el]);
			}
			if(!setP.equals(setQ))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		int i = 0;
		while (i < nTestCases) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int[] p = new int[n];
			int[] q = new int[n];

			for (int j = 0; j < n; j++) {
				p[j] = scanner.nextInt() - 1;
			}

			for (int j = 0; j < n; j++) {
				q[j] = scanner.nextInt() - 1;
			}

			LinkedList<Integer>[] edges = new LinkedList[n];
			for (int j = 0; j < n; j++) {
				edges[j] = new LinkedList<Integer>();
			}
			int k = 0;
			while (k < m) {
				int v1 = scanner.nextInt();
				int v2 = scanner.nextInt();
				edges[v1 - 1].add(v2 - 1);
				edges[v2 - 1].add(v1 - 1);
				k++;
			}
			boolean possible = ifPossible(p, q, edges, n);
			if(possible) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			i++;
		}

		scanner.close();
	}

}
