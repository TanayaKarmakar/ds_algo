package com.app.graph.classroom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSSimpleGraph {
	private static ArrayList<ArrayList<Integer>> createGraph(int nVertices) {
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(nVertices);
		for (int i = 0; i < nVertices; i++) {
			adjList.add(new ArrayList<>());
		}
		return adjList;
	}

	private static void addEdge(ArrayList<ArrayList<Integer>> adjList, int u, int v) {
		adjList.get(u).add(v);
		adjList.get(v).add(u);
	}
	
	private static void printGraph(ArrayList<ArrayList<Integer>> adjList) {
		for (int i = 0; i < adjList.size(); i++) {
			System.out.print(i + " -> ");
			for (Integer el : adjList.get(i)) {
				System.out.print(el + " ");
			}
			System.out.println();
		}
	}
	
	private static void bfs(ArrayList<ArrayList<Integer>> adjList, int source) {
		boolean[] visited = new boolean[adjList.size()];
		Queue<Integer> nodeQ = new LinkedList<>();
		nodeQ.add(source);
		visited[source] = true;
		
		while(!nodeQ.isEmpty()) {
			int node = nodeQ.poll();
			System.out.print(node + " ");
			ArrayList<Integer> nodes = adjList.get(node);
			for(Integer el: nodes) {
				if(visited[el] == false) {
					visited[el] = true;
					nodeQ.add(el);
				}
			}
		}
		
		System.out.println();
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adjList = createGraph(6);
		
		addEdge(adjList, 0, 1);
		addEdge(adjList, 0, 2);
		addEdge(adjList, 0, 5);
		addEdge(adjList, 1, 3);
		addEdge(adjList, 2, 4);
		addEdge(adjList, 3, 5);
		addEdge(adjList, 4, 5);
		
		//printGraph(adjList);
		bfs(adjList, 0);
	}

}
