package com.app.questions.graphbfsdfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Edge {
	String node;
	double weight;
	
	public Edge(String node, double weight) {
		this.node = node;
		this.weight = weight;
	}
	
	public String toString() {
		return node + " - " + weight;
	}
}

public class EvaluateDivisionLeetcode399 {
	private static double dfs(Map<String, List<Edge>> adjList, String source, 
			String dest, Set<String> visited, double value) {
		if(source.equals(dest)) {
			return value;
		}
		
		if(visited.contains(source))
			return value;
			
		visited.add(source);
		List<Edge> edges = adjList.get(source);
		for(Edge edge: edges) {
			if(!visited.contains(edge.node)) {
				double val = dfs(adjList, edge.node, dest, visited, value);
				if(val != -1)
					return val * edge.weight;
			}
		}
		return -1;
	}

	private static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		Map<String, List<Edge>> adjList = new HashMap<>();
		
		int n = equations.size();
		
		for(int i = 0; i < n; i++) {
			List<String> equation = equations.get(i);
			double value = values[i];
			
			String v1 = equation.get(0);
			String v2 = equation.get(1);
			
			Edge e1 = new Edge(v2, value);
			Edge e2 = new Edge(v1, 1 / value);
			
			if(!adjList.containsKey(v1)) {
				List<Edge> edges = new ArrayList<>();
				edges.add(e1);
				adjList.put(v1, edges);
			} else {
				adjList.get(v1).add(e1);
			}
			
			if(!adjList.containsKey(v2)) {
				List<Edge> edges = new ArrayList<>();
				edges.add(e2);
				adjList.put(v2, edges);
			} else {
				adjList.get(v2).add(e2);
			}
		}
		
		double[] res = new double[queries.size()];
		int i = 0;
		
		for(List<String> query: queries) {
			String source = query.get(0);
			String dest = query.get(1);
			if(source.equals(dest)) {
				if(adjList.containsKey(source))
					res[i++] = 1.0;
				else
					res[i++] = -1.0;
			} else if(!adjList.containsKey(source) || !adjList.containsKey(dest)) {
				res[i++] = -1.0;
			} else {
				Set<String> visited = new HashSet<>();
				double value = dfs(adjList, source, dest, visited, 1.0);
				res[i++] = value;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		List<List<String>> equations = new ArrayList<>();
		
		List<String> item1 = new ArrayList<>();
		item1.add("x1");
		item1.add("x2");
		
		equations.add(item1);
		
		item1 = new ArrayList<>();
		item1.add("x2");
		item1.add("x3");
		
		equations.add(item1);
		
		item1 = new ArrayList<>();
		item1.add("x3");
		item1.add("x4");
		
		equations.add(item1);
		
		item1 = new ArrayList<>();
		item1.add("x4");
		item1.add("x5");
		equations.add(item1);
		
		double[] values = {3.0, 4.0, 5.0, 6.0};
		
		List<List<String>> queries = new ArrayList<>();
		item1 = new ArrayList<>();
		
		item1.add("x1");
		item1.add("x5");
		queries.add(item1);
		
		item1 = new ArrayList<>();
		item1.add("x5");
		item1.add("x2");
		
		queries.add(item1);
		
		item1 = new ArrayList<>();
		item1.add("x2");
		item1.add("x4");
		queries.add(item1);
		
		item1 = new ArrayList<>();
		item1.add("x2");
		item1.add("x2");
		queries.add(item1);
		
		item1 = new ArrayList<>();
		item1.add("x2");
		item1.add("x9");
		queries.add(item1);
		
		item1 = new ArrayList<>();
		item1.add("x9");
		item1.add("x9");
		queries.add(item1);
		
		double[] res = calcEquation(equations, values, queries);
		
		System.out.println(Arrays.toString(res));

	}

}
