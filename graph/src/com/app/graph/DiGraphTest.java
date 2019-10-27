package com.app.graph;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DiGraphTest {
//	private static void topologicalSort(DiGraph dg) {
//		int nVertices = dg.getAdjList().size();
//		int[] inDeg = dg.getInDegree();
//
//		int count = 0;
//		Map<Vertex, List<Vertex>> map = dg.getAdjList();
//		while (count < nVertices) {
//			int startId = findStartIndx(inDeg, nVertices);
//			System.out.print(startId + "\t");
//			List<Vertex> edges = map.get(new Vertex(startId));
//			for (Vertex edge : edges) {
//				inDeg[edge.getLabel()]--;
//			}
//			inDeg[startId] = -1;
//			map.remove(startId);
//			count++;
//		}
//
//	}

//	private static int findStartIndx(int[] inDeg, int nVertices) {
//		for (int i = 0; i < nVertices; i++) {
//			if (inDeg[i] == 0) {
//				return i;
//			}
//		}
//		return -1;
//	}

	public static void main(String[] args) {
		DiGraph dg = new DiGraph(6);
		IntStream.range(0, 6).forEach(item -> {
			dg.addVertex(item);
		});

		dg.addEdge(2, 0);
		dg.addEdge(2, 3);
		dg.addEdge(0, 1);
		dg.addEdge(0, 3);
		dg.addEdge(0, 5);
		dg.addEdge(3, 1);
		dg.addEdge(3, 4);
		dg.addEdge(5, 4);

		dg.displayGraph();

		System.out.println("InDegree - " + Arrays.toString(dg.getInDegree()));

		//topologicalSort(dg);
	}

}
