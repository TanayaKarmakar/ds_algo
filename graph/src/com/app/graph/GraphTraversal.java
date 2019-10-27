package com.app.graph;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import com.app.graph.Graph.Vertex;

public class GraphTraversal {
	public Set<String> depthFirstTraversal(Graph graph, String root) {
		Stack<String> stack = new Stack<>();
		Set<String> visited = new LinkedHashSet<>();

		stack.push(root);
		while (!stack.isEmpty()) {
			String label = stack.pop();
			if (!visited.contains(label)) {
				visited.add(label);
				for (Vertex vert : graph.getAdjVertices(label)) {
					stack.push(vert.getLabel());
				}
			}
		}
		
		return visited;
	}

	public Set<String> breadthFirstTraversal(Graph graph, String root) {
		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new LinkedHashSet<>();
		
		queue.add(root);
		visited.add(root);
		
		while(!queue.isEmpty()) {
			String vert = queue.poll();
			
			for(Vertex vertex: graph.getAdjVertices(vert)) {
				String label = vertex.getLabel();
				if(!visited.contains(label)) {
					visited.add(label);
					queue.add(label);
				}
			}
		}
		
		return visited;
	}

}
