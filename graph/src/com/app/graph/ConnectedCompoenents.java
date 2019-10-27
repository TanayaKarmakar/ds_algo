package com.app.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.IntStream;

import com.app.graph.Graph.Vertex;

public class ConnectedCompoenents {
	private static void displayGraph(Graph graph) {
		Map<Vertex, List<Vertex>> adjList = graph.adjList;
		for (Map.Entry<Vertex, List<Vertex>> entry : adjList.entrySet()) {
			System.out.print(entry.getKey().getLabel() + "\t");
			for (Vertex vert : entry.getValue()) {
				System.out.print(vert.getLabel() + " -> ");
			}
			System.out.println();
		}

	}

	private static int numberOfConnectedComponents(Graph graph) {
		int count = 0;
		Set<String> visited = new HashSet<>();
		Map<Vertex, List<Vertex>> adjList = graph.adjList;
		for (Map.Entry<Vertex, List<Vertex>> entry : adjList.entrySet()) {
			if(!visited.contains(entry.getKey().getLabel())) {
				count++;
				depthFirstTraversal(graph, entry.getKey().getLabel(), visited);
			}
		}
		return count;
	}
	
	private static void printConnectedComponents(Graph graph) {
		Map<Vertex, List<Vertex>> adjList = graph.adjList;
		Set<String> visited = new HashSet<>();
		for(Map.Entry<Vertex, List<Vertex>> entry: adjList.entrySet()) {
			if(!visited.contains(entry.getKey().getLabel())) {
				printDepthFirstTraversal(graph, entry.getKey().getLabel(), visited);
			}
		}
	}
	
	private static void printDepthFirstTraversal(Graph graph, String root, Set<String> visited) {
		Stack<String> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			String label = stack.pop();
			if(!visited.contains(label)) {
				visited.add(label);
				System.out.print(label + "\t");
				for(Vertex vertex: graph.getAdjVertices(label)) {
					stack.push(vertex.getLabel());
				}
			}
		}
		System.out.println();
	}
	
	private static void depthFirstTraversal(Graph graph, String root,Set<String> visited) {
		Stack<String> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			String label = stack.pop();
			if(!visited.contains(label)) {
				visited.add(label);
				for(Vertex vertex: graph.getAdjVertices(label) ) {
					stack.push(vertex.getLabel());
				}
			}
		}
	}

	public static void main(String[] args) {
		Graph graph = new Graph();

		IntStream.range(1, 19).forEach(item -> {
			graph.addVertex(String.valueOf(item));
		});

		graph.addEdges("1", "8");
		graph.addEdges("1", "9");
		graph.addEdges("1", "10");
		graph.addEdges("1", "11");
		graph.addEdges("10", "11");
		
		graph.addEdges("2", "3");
		graph.addEdges("2", "4");
		graph.addEdges("2", "5");
		graph.addEdges("2", "6");
		graph.addEdges("5", "6");
		
		graph.addEdges("7", "12");
		graph.addEdges("7", "13");
		graph.addEdges("12", "14");
		graph.addEdges("14", "15");
		
		graph.addEdges("16", "17");

		//displayGraph(graph);
		graph.displayGraph();
		
		System.out.println("Number of connected components - " + numberOfConnectedComponents(graph));
		
		System.out.println("Connected components for the graph - ");
		printConnectedComponents(graph);
	}

}
