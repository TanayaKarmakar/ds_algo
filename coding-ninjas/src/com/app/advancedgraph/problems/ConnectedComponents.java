package com.app.advancedgraph.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class ConnectedComponents {
	private static void dfs(LinkedList<Integer>[] edges, int start, 
			boolean[] visited, Set<Integer> components) {
		visited[start] = true;
		components.add(start);
		LinkedList<Integer> nodes = edges[start];
		for(Integer node: nodes) {
			if(!visited[node]) {
				dfs(edges, node, visited, components);
			}
		}
	}
	
	
	private static Set<Set<Integer>> getComponents(LinkedList<Integer>[] edges, int n) {
		boolean[] visited = new boolean[n];
		Set<Set<Integer>> components = new HashSet<>();
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				Set<Integer> component = new HashSet<>();
				dfs(edges, i, visited, component);
				components.add(component);
			}
		}
		return components;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nV = scanner.nextInt();
		int nE = scanner.nextInt();
		
		LinkedList<Integer>[] edges = new LinkedList[nV];
		for(int i = 0; i < nV; i++) {
			edges[i] = new LinkedList<Integer>();
		}
		int i = 0;
		while(i < nE) {
			int v1 = scanner.nextInt();
			int v2 = scanner.nextInt();
			
			edges[v1].add(v2);
			edges[v2].add(v1);
			i++;
		}
		
		Set<Set<Integer>> components = getComponents(edges, nV);
		
		for(Set<Integer> component: components) {
			for(int el: component) {
				System.out.print(el + " ");
			}
			System.out.println();
		}
		
		scanner.close();

	}

}
