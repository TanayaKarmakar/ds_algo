package com.app.graph.classroom;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnsAlgorithmForCycleDetection {
	private static int[] buildInDegreeArray(DiGraph dg) {
		int nVertices = dg.size();
		int[] indegree = new int[nVertices];

		for (int i = 0; i < nVertices; i++) {
			List<Integer> nodeList = dg.getEdges(i);
			for (Integer node : nodeList) {
				indegree[node]++;
			}
		}

		return indegree;
	}

	private static boolean hasCycle(DiGraph dg) {
		int[] indegree = buildInDegreeArray(dg);
		Queue<Integer> nodeQ = new LinkedList<>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				nodeQ.add(i);
			}
		}
		
		int count = 0;
		while(!nodeQ.isEmpty()) {
			Integer node = nodeQ.poll();
			List<Integer> nodeList = dg.getEdges(node);
			
			for(Integer el: nodeList) {
				indegree[el]--;
				if(indegree[el] == 0) {
					nodeQ.add(el);
				}
			}
			count++;
		}
		
		if(count != dg.size())
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		int nVertices = 4;
		DiGraph dg = new DiGraph(nVertices);
		dg.addEdge(0, 1);
		dg.addEdge(1, 2);
		dg.addEdge(2, 0);
		dg.addEdge(2, 3);
		
		System.out.println(hasCycle(dg));
		
		dg = new DiGraph(nVertices);
		dg.addEdge(0, 1);
		dg.addEdge(1, 2);
		dg.addEdge(2, 3);
		
		System.out.println(hasCycle(dg));

	}

}
