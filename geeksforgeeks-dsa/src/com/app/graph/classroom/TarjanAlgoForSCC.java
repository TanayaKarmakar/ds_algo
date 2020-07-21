package com.app.graph.classroom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class TarjanAlgoForSCC {
	private static int[] low;
	private static int pre;
	private static int count;
	private static Stack<Integer> stack;
	private static List<List<Integer>> sccComponents;
	
	private static void init(int n) {
		low = new int[n];
		pre = 0;
		count = 0;
		stack = new Stack<>();
		sccComponents = new ArrayList<>();
	}
	
	private static void dfs(LinkedList[] edges, int v, boolean[] visited) {
		low[v] = pre++;
		visited[v] = true;
		stack.push(v);
		int min = low[v];
		
		LinkedList<Integer> nodes = edges[v];
		for(Integer node: nodes) {
			if(!visited[node])
				dfs(edges, node, visited);
			if(low[node] < min)
				min = low[node];
		}
		
		if(low[v] > min) {
			low[v] = min;
			return;
		}
		
		int w;
		List<Integer> comps = new ArrayList<>();
		do {
			w = stack.pop();
			comps.add(w);
			low[w] = edges.length;
		} while(w != v);
		sccComponents.add(comps);
		count++;
	}
	
	private static void startProcessing(LinkedList[] edges, int n) {
		init(n);
		boolean[] visited = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				dfs(edges, i, visited);
			}
		}
	}
	
	private static int count() {
		return count;
	}
	
	private static void printEdges(LinkedList[] edges) {
		int n = edges.length;
		for(int i = 0; i < n; i++) {
			System.out.println(i + " -> " + edges[i]);
		}
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
		
		printEdges(edges);
		startProcessing(edges, n);
		
		System.out.println(sccComponents);
		
		System.out.println("Count - " + count());

		scanner.close();
	}

}
