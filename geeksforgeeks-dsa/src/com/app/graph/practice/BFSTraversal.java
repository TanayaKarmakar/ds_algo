package com.app.graph.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.app.graph.classroom.Graph;

public class BFSTraversal {
	private static void traversal(int s, ArrayList<ArrayList<Integer>> list, boolean[] vis, int nov) {
		vis[s] = true;
		Queue<Integer> nodeQ = new LinkedList<>();
		nodeQ.add(s);
		while (!nodeQ.isEmpty()) {
			Integer node = nodeQ.poll();
			System.out.print(node + " ");
			List<Integer> nodeList = list.get(node);
			for (Integer el : nodeList) {
				if (!vis[el]) {
					nodeQ.add(el);
					vis[el] = true;
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 3);

		boolean[] vis = new boolean[4];

		traversal(0, g.getAdjList(), vis, 4);

	}

}
