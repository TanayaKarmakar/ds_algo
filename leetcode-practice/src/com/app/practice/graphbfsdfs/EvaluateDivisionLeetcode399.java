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
	private static double dfs(Map<String, List<Edge1>> map, String source, String dest, Set<String> visited,
			double weight) {
		if (source.equals(dest))
			return weight;
		if (visited.contains(source))
			return weight;
		visited.add(source);
		List<Edge1> edges = map.get(source);
		for (Edge1 ed : edges) {
			if (!visited.contains(ed.node)) {
				double val = dfs(map, ed.node, dest, visited, weight);
				if (val != -1)
					return val * ed.weight;
			}

		}

		return -1;
	}

	private static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		int n = equations.size();

		Map<String, List<Edge1>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			List<String> equation = equations.get(i);
			double weight = values[i];

			if (!map.containsKey(equation.get(0))) {
				map.put(equation.get(0), new ArrayList<>());
			}
			Edge1 edge1 = new Edge1(equation.get(1), weight);
			map.get(equation.get(0)).add(edge1);

			if (!map.containsKey(equation.get(1))) {
				map.put(equation.get(1), new ArrayList<>());
			}
			Edge1 edge2 = new Edge1(equation.get(0), 1 / weight);
			map.get(equation.get(1)).add(edge2);
		}

		double[] res = new double[queries.size()];

		for (int i = 0; i < queries.size(); i++) {
			List<String> query = queries.get(i);
			String source = query.get(0);
			String dest = query.get(1);

			if (source.equals(dest)) {
				if (map.containsKey(source))
					res[i] = 1.0;
				else
					res[i] = -1.0;
			} else if (!map.containsKey(source) || !map.containsKey(dest)) {
				res[i] = -1.0;
			} else {
				Set<String> visited = new HashSet<>();
				double weight = dfs(map, source, dest, visited, 1.0);
				res[i] = weight;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		List<List<String>> equations = new ArrayList<>();
		List<String> value = new ArrayList<>();
		value.add("a");
		value.add("b");
		equations.add(value);

		value = new ArrayList<>();
		value.add("b");
		value.add("c");
		equations.add(value);

		int size = equations.size();
		double[] values = new double[size];
		values[0] = 2.0;
		values[1] = 3.0;

		List<List<String>> queries = new ArrayList<>();
		value = new ArrayList<>();
		value.add("a");
		value.add("c");
		queries.add(value);

		value = new ArrayList<>();
		value.add("b");
		value.add("a");
		queries.add(value);

		value = new ArrayList<>();
		value.add("a");
		value.add("e");
		queries.add(value);

		double[] res = calcEquation(equations, values, queries);

		System.out.println(Arrays.toString(res));

	}

}
