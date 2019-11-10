package com.app.graph.practice;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.IntStream;

import com.app.graph.practice.GraphPractice.Vertex;

public class ConnectedComponentsPractice {
	private static void printDFS(Vertex vert, Map<Vertex, List<Vertex>> adjList, Set<String> visited) {
		Stack<Vertex> stack = new Stack<>();
		stack.push(vert);
		
		while(!stack.isEmpty()) {
			Vertex v = stack.pop();
			if(!visited.contains(v.getLabel())) {
				System.out.print(v.getLabel() + "\t");
				visited.add(v.getLabel());
				List<Vertex> vertices = adjList.get(v);
				for(Vertex vertex: vertices) {
					stack.push(vertex);
				}
			}
		}
		
		System.out.println();
	}
	
	private static void printConnectedComponents(GraphPractice graph) {
		Map<Vertex, List<Vertex>> adjList = graph.adjList;
		Set<String> visited = new HashSet<>();
		
		for(Map.Entry<Vertex, List<Vertex>> entry: adjList.entrySet()) {
			if(!visited.contains(entry.getKey().getLabel())) {
				printDFS(entry.getKey(), adjList, visited);
			}		
		}
	}
	
	
	private static void dfs(Vertex vert, Map<Vertex, List<Vertex>> adjList, Set<String> visited) {
		Stack<Vertex> stack = new Stack<>();
			
		stack.push(vert);
		while(!stack.isEmpty()) {
			Vertex v = stack.pop();
			if(!visited.contains(v.getLabel())) {
				visited.add(v.getLabel());
				List<Vertex> vertices = adjList.get(v);
				for(Vertex vertex: vertices) {
					stack.push(vertex);
				}
			}
		}
	}
	
	private static int numberOfConnectedComponents(GraphPractice graph) {
		Map<Vertex, List<Vertex>> adjList = graph.adjList;
		Set<String> visited = new HashSet<>();
		int connectedComponents = 0;
		for(Map.Entry<Vertex, List<Vertex>> entry: adjList.entrySet()) {
			if(!visited.contains(entry.getKey().getLabel())) {
				connectedComponents++;
				dfs(entry.getKey(), adjList, visited);
			}
		}
		
		return connectedComponents;
	}

	public static void main(String[] args) {
		GraphPractice graph = new GraphPractice();
		IntStream.rangeClosed(1, 14).forEach(item -> {
			graph.addVertex(String.valueOf(item));
		});
		
		graph.addEdge("1", "2");
		graph.addEdge("1", "3");
		graph.addEdge("2", "4");
		graph.addEdge("3", "4");
		graph.addEdge("3", "6");
		graph.addEdge("6", "5");
		graph.addEdge("6", "8");
		graph.addEdge("7", "5");
		graph.addEdge("7", "8");

		graph.addEdge("9", "10");
		
		graph.addEdge("11", "12");
		graph.addEdge("11", "13");
		graph.addEdge("12", "13");
		
		System.out.println("Number of connected components - " + numberOfConnectedComponents(graph));
		
		System.out.println("Connected Components for the graph ");
		printConnectedComponents(graph);
	}

}
