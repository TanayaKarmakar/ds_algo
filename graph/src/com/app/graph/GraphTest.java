package com.app.graph;

import java.util.Set;

public class GraphTest {

	public static void main(String[] args) {
		Graph graph = new Graph();
		//add vertices
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		
		//create connections - create edges
		graph.addEdges("A", "B");
		graph.addEdges("A", "C");
		graph.addEdges("B", "E");
		graph.addEdges("C", "D");
		graph.addEdges("C", "E");
		graph.addEdges("D", "E");
		
		graph.displayGraph();
		
		GraphTraversal gt = new GraphTraversal();
		Set<String> traversedSet = gt.depthFirstTraversal(graph, "A");
		for(String str: traversedSet) {
			System.out.print(str + "\t");
		}
		System.out.println("\n");
		
		traversedSet = gt.breadthFirstTraversal(graph, "A");
		for(String str: traversedSet) {
			System.out.print(str + "\t");
		}
		System.out.println("\n");
	}

}
