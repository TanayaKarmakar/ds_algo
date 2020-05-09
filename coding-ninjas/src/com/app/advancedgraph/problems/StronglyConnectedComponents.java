package com.app.advancedgraph.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

//Kosaraju's algo
public class StronglyConnectedComponents {
	private static void dfs(LinkedList<Integer>[] edges, int start, Set<Integer> visited, Stack<Integer> stack) {
		visited.add(start);
		LinkedList<Integer> nodes = edges[start];
		for (Integer node : nodes) {
			if (!visited.contains(node)) {
				dfs(edges, node, visited, stack);
			}
		}
		stack.push(start);
	}
	
	private static void dfs2(LinkedList<Integer>[] edgesT, int start, Set<Integer> visited, Set<Integer> component) {
		visited.add(start);
		component.add(start);
		LinkedList<Integer> nodes = edgesT[start];
		for(Integer node: nodes) {
			if(!visited.contains(node)) {
				dfs2(edgesT, node, visited, component);
			}
		}
	}

	private static Set<Set<Integer>> getScc(LinkedList<Integer>[] edges, LinkedList<Integer>[] edgesT, 
			int nV) {
		Stack<Integer> stack = new Stack<>();
		Set<Integer> visited = new HashSet<>();
		for (int i = 0; i < nV; i++) {
			if (!visited.contains(i)) {
				dfs(edges, i, visited, stack);
			}
		}

		visited.clear();
		Set<Set<Integer>> components = new HashSet<>();
		while(!stack.isEmpty()) {
			int node = stack.pop();
			if(!visited.contains(node)) {
				Set<Integer> component = new HashSet<>();
				dfs2(edgesT, node, visited, component);
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
		LinkedList<Integer>[] edgesT = new LinkedList[nV];
		
		for(int i = 0; i < nV; i++) {
			edges[i] = new LinkedList<Integer>();
			edgesT[i] = new LinkedList<Integer>();
		}

		int i = 0;
		while (i < nE) {
			int v1 = scanner.nextInt();
			int v2 = scanner.nextInt();

			edges[v1 - 1].add(v2 - 1);
			edgesT[v2 - 1].add(v1 - 1);
			i++;
		}

		Set<Set<Integer>> components = getScc(edges, edgesT, nV);
		for(Set<Integer> component: components) {
			for(Integer el: component) {
				System.out.print(el + " ");
			}
			System.out.println();
		}
		
		scanner.close();
	}

}
