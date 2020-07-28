package com.app.problems.gfg.dfsbfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class MotherVertices {
	private static void dfs(LinkedList<Integer>[] edges, int v, Set<Integer> visited) {
		visited.add(v);
		LinkedList<Integer> neighbors = edges[v];
		
		for(Integer nei: neighbors) {
			if(!visited.contains(nei))
				dfs(edges, nei, visited);
		}
	}
	
	private static List<Integer> findMotherVertices(LinkedList<Integer>[] edges, int n) {
		List<Integer> res = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			Set<Integer> visited = new HashSet<>();
			dfs(edges, i, visited);
			
			if(visited.size() == n)
				res.add(i);
		}
		
		return res;
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
		
		List<Integer> res = findMotherVertices(edges, n);
		
		System.out.println(res);
		
		scanner.close();

	}

}
