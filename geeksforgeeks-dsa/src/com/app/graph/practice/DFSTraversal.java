package com.app.graph.practice;

import java.util.ArrayList;
import java.util.List;

import com.app.graph.classroom.Graph;

public class DFSTraversal {
	private static void traversal(ArrayList<ArrayList<Integer>> list, boolean[] visited, int source) {
		System.out.print(source + " ");
		visited[source] = true;
		List<Integer> nodeList = list.get(source);
		for(Integer node: nodeList) {
			if(!visited[node]) {
				traversal(list, visited, node);
			}
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 3);

		boolean[] vis = new boolean[4];

		traversal(g.getAdjList(), vis, 0);


	}

}
