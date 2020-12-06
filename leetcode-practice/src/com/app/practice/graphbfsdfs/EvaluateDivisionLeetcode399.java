package com.app.practice.graphbfsdfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class ValueNode {
	String node;
	double value;

	public ValueNode(String node, double value) {
		this.node = node;
		this.value = value;
	}
}

public class EvaluateDivisionLeetcode399 {
	private static double ans = 1.0;

	private static boolean dfs(Map<String, List<ValueNode>> adjList, String source, String dest, Set<String> visited) {
		if (source.equals(dest))
			return true;
		visited.add(source);
		List<ValueNode> valueNodes = adjList.get(source);
		for (ValueNode vNode : valueNodes) {
			if (!visited.contains(vNode.node)) {
				ans = ans * vNode.value;
				if(dfs(adjList, vNode.node, dest, visited) == true)
					return true;
				ans = ans / vNode.value;
			}
		}
		return false;
	}

	private static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		Map<String, List<ValueNode>> adjList = new HashMap<>();

		int n = equations.size();

		for (int i = 0; i < n; i++) {
			List<String> eq = equations.get(i);
			double value = values[i];

			String s = eq.get(0);
			String t = eq.get(1);

			if (!adjList.containsKey(s))
				adjList.put(s, new ArrayList<>());
			adjList.get(s).add(new ValueNode(t, value));

			if (!adjList.containsKey(t))
				adjList.put(t, new ArrayList<>());
			adjList.get(t).add(new ValueNode(s, 1 / value));
		}

		int m = queries.size();
		double[] result = new double[m];
		int i = 0;

		for (List<String> query : queries) {
			String source = query.get(0);
			String dest = query.get(1);

			if (!adjList.containsKey(source) || !adjList.containsKey(dest))
				result[i] = -1.0;
			else if (source.equals(dest))
				result[i] = 1.0;
			else {
				ans = 1.0;
				Set<String> visited = new HashSet<>();
				boolean hasPath = dfs(adjList, source, dest, visited);
				result[i] = hasPath ? ans: -1.0;
			}
			i++;
		}
		
		return result;
	}

	public static void main(String[] args) {
		List<List<String>> equations = new ArrayList<>();
		
		List<String> l1 = new ArrayList<>();
		l1.add("a");
		l1.add("b");
		equations.add(l1);
		
		List<String> l2 = new ArrayList<>();
		l2.add("b");
		l2.add("c");
		equations.add(l2);
		
		double[] values = new double[2];
		values[0] = 2.0;
		values[1] = 3.0;
		
		List<List<String>> queries = new ArrayList<>();
		List<String> q1 = new ArrayList<>();
		q1.add("a");
		q1.add("c");
		queries.add(q1);
		
		List<String> q2 = new ArrayList<>();
		q2.add("b");
		q2.add("a");
		queries.add(q2);
		
		List<String> q3 = new ArrayList<>();
		q3.add("a");
		q3.add("e");
		queries.add(q3);
		
		List<String> q4 = new ArrayList<>();
		q4.add("a");
		q4.add("a");
		queries.add(q4);
		
		double[] ans = calcEquation(equations, values, queries);
		
		System.out.println(Arrays.toString(ans));

	}

}
