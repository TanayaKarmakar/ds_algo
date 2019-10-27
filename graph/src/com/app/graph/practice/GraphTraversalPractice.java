package com.app.graph.practice;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.IntStream;

import com.app.graph.practice.GraphPractice.Vertex;

public class GraphTraversalPractice {
	private static void breadthFirstTraversal(GraphPractice gp, String startNode) {
		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new LinkedHashSet<>();
		queue.add(startNode);
		visited.add(startNode);
		
		while(!queue.isEmpty()) {
			String currentNode = queue.poll();
			List<Vertex> vertices = gp.adjList.get(new Vertex(currentNode));
			for(Vertex vert: vertices) {
				if(!visited.contains(vert.getLabel())) {
					visited.add(vert.getLabel());
					queue.add(vert.getLabel());
				}
			}
		}
		
		System.out.println("visited");
		System.out.println(visited);
	}
	
	private static void depthFirstTraversal(GraphPractice gp, String startNode) {
		Stack<String> stack = new Stack<>();
		Set<String> visited = new LinkedHashSet<>();
		
		stack.push(startNode);
		while(!stack.isEmpty()) {
			String node = stack.pop();
			if(!visited.contains(node)) {
				visited.add(node);
				List<Vertex> vertices = gp.adjList.get(new Vertex(node));
				for(Vertex vert: vertices) {
					stack.push(vert.getLabel());
				}
			}
		}
		
		System.out.println("DFS ");
		System.out.println(visited);
	}

	public static void main(String[] args) {
		GraphPractice gp = new GraphPractice();
		
		int nVertices = 5;
		IntStream.range(1, nVertices + 1).forEach(item -> {
			gp.addVertex(String.valueOf(item));;
		});
		
		gp.addEdge("1", "2");
		gp.addEdge("1", "3");
		gp.addEdge("1", "4");
		gp.addEdge("2", "3");
		gp.addEdge("3", "5");
		gp.addEdge("4", "5");
		
		gp.displayGraph();
		depthFirstTraversal(gp, "1");
		
		breadthFirstTraversal(gp, "1");

	}

}
