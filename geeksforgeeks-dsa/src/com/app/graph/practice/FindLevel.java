package com.app.graph.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.app.graph.classroom.Graph;

public class FindLevel {
	private static int level(ArrayList<ArrayList<Integer>> list, int x, int in) {
		int nVertices = list.size();
		boolean[] visited = new boolean[nVertices];
		Queue<Integer> q = new LinkedList<>();
		int level = 0;
		q.add(x);
		q.add(null);
		visited[x] = true;
		while(!q.isEmpty()) {
			Integer node = q.poll();
			if(node == null) {
				level++;
				q.add(null);
			}
			else if(node == in)
				return level;
			if(node != null) {
				List<Integer> nodeList = list.get(node);
				for(Integer el: nodeList) {
					if(!visited[el]) {
						q.add(el);
						visited[el] = true;
					}
				}
			}
			
		}
		return -1;
	}

	public static void main(String[] args) {
		Graph g = new Graph(8);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(1, 5);
		g.addEdge(2, 6);
		g.addEdge(6, 7);
		g.addEdge(2, 5);
		
		System.out.println("Level - " + level(g.getAdjList(), 0, 7));
	}

}
