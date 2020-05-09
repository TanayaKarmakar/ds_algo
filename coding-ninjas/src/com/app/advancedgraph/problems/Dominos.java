package com.app.advancedgraph.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Dominos {

	private static void dfs(LinkedList<Integer>[] edges, int start, Stack<Integer> stack, Set<Integer> visited) {
		visited.add(start);
		LinkedList<Integer> nodes = edges[start];
		for (Integer node : nodes) {
			if(!visited.contains(node))
				dfs(edges, node, stack, visited);
		}
		stack.push(start);
	}
	
	private static void dfs2(LinkedList<Integer>[] edges, int start, Set<Integer> visited) {
		visited.add(start);
		
		LinkedList<Integer> nodes = edges[start];
		for(Integer node: nodes) {
			if(!visited.contains(node)) {
				dfs2(edges, node, visited);
			}
		}
	}
	
	private static int getMinDomino(LinkedList<Integer>[] edges, int nV) {
		Stack<Integer> stack = new Stack<>();
		Set<Integer> visited = new HashSet<>();

		for (int i = 0; i < nV; i++) {
			if (!visited.contains(i)) {
				dfs(edges, i, stack, visited);
			}
		}

		visited.clear();
		int count = 0;
		while(!stack.isEmpty()) {
			int node = stack.pop();
			if(!visited.contains(node)) {
				dfs2(edges, node, visited);
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();

		int i = 0;
		while (i < nTestCases) {
			int nV = scanner.nextInt();
			int nE = scanner.nextInt();
			LinkedList<Integer>[] edges = new LinkedList[nV];
			for (int j = 0; j < nV; j++) {
				edges[j] = new LinkedList<Integer>();
			}

			for (int j = 0; j < nE; j++) {
				int v1 = scanner.nextInt();
				int v2 = scanner.nextInt();

				edges[v1 - 1].add(v2 - 1);
			}
			
			int count = getMinDomino(edges, nV);
			
			System.out.println(count);

			i++;
		}
		scanner.close();
	}

}
