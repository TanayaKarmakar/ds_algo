package com.app.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class TarjanAlgorithmForSCC {
	private static final int UNVISITED = -1;
	private static int id = 0;

	private static void dfs(List<List<Integer>> dg, int nodeIndx, int[] ids, int[] low, boolean[] onStack, Stack<Integer> stack) {
		ids[nodeIndx] = low[nodeIndx] = id++;
		stack.push(nodeIndx);
		onStack[nodeIndx] = true;
		
		List<Integer> vertices = dg.get(nodeIndx);
		for(Integer vert: vertices) {
			if(ids[vert] == UNVISITED) {
				dfs(dg, vert, ids, low, onStack, stack);
			}
			if(onStack[vert] == true) {
				low[nodeIndx] = Math.min(low[nodeIndx], low[vert]);
			}
		}
		
		if(ids[nodeIndx] == low[nodeIndx]) {
			while(stack.peek() != nodeIndx) {
				int currNode = stack.pop();
				low[currNode] = ids[nodeIndx];
				onStack[currNode] = false;
			}
			int node = stack.peek();
			onStack[node] = false;
			stack.pop();
		}
	}

	private static int[] findStronglyConnectedComponents(List<List<Integer>> dg, int nVertices) {
		int[] ids = new int[nVertices];
		int[] low = new int[nVertices];
		boolean[] onStack = new boolean[nVertices];
		Stack<Integer> stack = new Stack<>();
		Arrays.fill(ids, UNVISITED);
		id = 0;
		//int sccCount = 0;

		for (int i = 0; i < nVertices; i++) {
			if (ids[i] == UNVISITED) {
				dfs(dg, i, ids, low, onStack, stack);
			}
		}
		
		return low;
	}
	
	private static void addEdge(List<List<Integer>> graph, int src, int dest) {
		graph.get(src).add(dest);
	}

	public static void main(String[] args) {
		int nVertices = 8;
		
		List<List<Integer>> graph = new ArrayList<>();
		IntStream.range(0, nVertices).forEach(item-> {
			graph.add(new ArrayList<>());
		});
		
		addEdge(graph, 6, 0);
	    addEdge(graph, 6, 2);
	    addEdge(graph, 3, 4);
	    addEdge(graph, 6, 4);
	    addEdge(graph, 2, 0);
	    addEdge(graph, 0, 1);
	    addEdge(graph, 4, 5);
	    addEdge(graph, 5, 6);
	    addEdge(graph, 3, 7);
	    addEdge(graph, 7, 5);
	    addEdge(graph, 1, 2);
	    addEdge(graph, 7, 3);
	    addEdge(graph, 5, 0);
		
		System.out.println("Strongly connected components - " + 
		Arrays.toString(findStronglyConnectedComponents(graph, nVertices)));
	}

}
