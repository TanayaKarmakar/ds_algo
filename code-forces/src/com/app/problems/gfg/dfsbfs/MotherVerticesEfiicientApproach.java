package com.app.problems.gfg.dfsbfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class MotherVerticesEfiicientApproach {
	private static void dfs1(LinkedList<Integer>[] edges, int v, Set<Integer> visited, Stack<Integer> stack) {
		visited.add(v);
		
		LinkedList<Integer> neighbors = edges[v];
		for(Integer nei: neighbors) {
			if(!visited.contains(nei))
				dfs1(edges, nei, visited, stack);
		}
		
		stack.push(v);
	}
	
	private static void dfs2(LinkedList<Integer>[] edges, int v, Set<Integer> visited) {
		visited.add(v);
		
		LinkedList<Integer> neighbors = edges[v];
		
		for(Integer nei: neighbors) {
			if(!visited.contains(nei))
				dfs2(edges, nei, visited);
		}
	}
	
	private static int findMotherVertex(LinkedList<Integer>[] edges, int n) {
		Stack<Integer> stack = new Stack<>();
		
		Set<Integer> visited = new HashSet<>();
		
		for(int i = 0; i < n; i++) {
			if(!visited.contains(i))
				dfs1(edges, i, visited, stack);
		}
		
		int lastVisitedVertx = stack.peek();
		
		visited.clear();
		
		dfs2(edges, lastVisitedVertx, visited);
		
		if(visited.size() == n)
			return lastVisitedVertx;
		return -1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int e = scanner.nextInt();
		LinkedList<Integer>[] edges = new LinkedList[n];
		
		for(int i = 0; i < n; i++) {
			edges[i] = new LinkedList<>();
		}
		
		for(int i = 0; i < e; i++) {
			int v1 = scanner.nextInt();
			int v2 = scanner.nextInt();
			
			edges[v1].add(v2);
		}
		
		int res = findMotherVertex(edges, n);
		
		System.out.println(res);
		
		scanner.close();

	}

}
