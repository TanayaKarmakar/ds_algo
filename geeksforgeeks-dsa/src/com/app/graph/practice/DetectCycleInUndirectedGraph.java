package com.app.graph.practice;

import java.util.ArrayList;
import java.util.List;

import com.app.graph.classroom.Graph;

public class DetectCycleInUndirectedGraph {
	private static boolean dfsRec(ArrayList<ArrayList<Integer>> adjList, boolean[] visited,
			int vertex, int parent) {
		visited[vertex] = true;
		List<Integer> nodeList = adjList.get(vertex);
		for(Integer node: nodeList) {
			if(!visited[node]) {
				if(dfsRec(adjList, visited, node, vertex)) {
					return true;
				}
			} else if(node != parent)
				return true;
		}
		return false;
	}
	
	
	private static boolean isCycle(ArrayList<ArrayList<Integer>> adjList, int v) {
		boolean visited[] = new boolean[v];
		for(int i = 0;i<v;i++) {
			if(!visited[i] && dfsRec(adjList, visited, i, -1)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		
		
		System.out.println(isCycle(g.getAdjList(), 4));

	}

}
