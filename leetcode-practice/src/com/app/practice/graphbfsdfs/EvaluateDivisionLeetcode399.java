package com.app.practice.graphbfsdfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Edge1 {
	String node;
	double weight;
	
	public Edge1(String node, double weight) {
		this.node = node;
		this.weight = weight;
	}
	
}

public class EvaluateDivisionLeetcode399 {
	private static double dfs(Map<String, List<Edge1>> adjList, String v1, String v2, 
			double val, Set<String> visited) {
		if(v1.equals(v2)) {
			return val;
		}
		
		if(visited.contains(v1))
			return val;
			
		visited.add(v1);
		List<Edge1> edges = adjList.get(v1);
		for(Edge1 edge: edges) {
			if(!visited.contains(edge.node)) {
				double v = dfs(adjList, edge.node, v2, val, visited);
				if(v != -1)
					return v * edge.weight;
			}
		}
		return -1;
	}
	
	private static double[] calcEquation(List<List<String>> equations, double[] values, 
			List<List<String>> queries) {
		int n = equations.size();
		
		Map<String, List<Edge1>> adjList = new HashMap<>();
		
		for(int i = 0; i < n; i++) {
			List<String> equation = equations.get(i);
			
			double value = values[i];
			String v1 = equation.get(0);
			String v2 = equation.get(1);
			
			Edge1 e1 = new Edge1(v2, value);
			Edge1 e2 = new Edge1(v1, 1 / value);
			
			if(!adjList.containsKey(v1)) {
				List<Edge1> list = new ArrayList<>();
				list.add(e1);
				adjList.put(v1, list);
			} else {
				adjList.get(v1).add(e1);
			}
			
			if(!adjList.containsKey(v2)) {
				List<Edge1> list = new ArrayList<>();
				list.add(e2);
				adjList.put(v2, list);
			} else {
				adjList.get(v2).add(e2);
			}
		}
		
		int n1 = queries.size();
		double[] res = new double[n1];
		
		int i = 0;
		Set<String> visited = new HashSet<>();
		
		for(List<String> query: queries) {
			String v1 = query.get(0);
			String v2 = query.get(1);
			
			if(v1.equals(v2)) {
				if(adjList.containsKey(v1))
					res[i++] = -1;
				else
					res[i++] = 1;
			} else if(!adjList.containsKey(v1) || !adjList.containsKey(v2))
				res[i++] = -1;
			else {
				double value = dfs(adjList, v1, v2, 1, visited);
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
