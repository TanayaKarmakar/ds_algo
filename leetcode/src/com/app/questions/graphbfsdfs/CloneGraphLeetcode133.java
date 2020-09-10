package com.app.questions.graphbfsdfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}

public class CloneGraphLeetcode133 {
	private static void dfs2(Node node, Map<Integer, Node> map, Set<Integer> visited) {
		visited.add(node.val);
		List<Node> neighbors = node.neighbors;
		for (Node nei : neighbors) {
			Node newNode = map.get(nei.val);
			map.get(node.val).neighbors.add(newNode);
		}

		for (Node nei : neighbors) {
			if (!visited.contains(nei.val))
				dfs2(nei, map, visited);
		}
	}

	private static void dfs1(Node node, Map<Integer, Node> map, Set<Integer> visited) {
		visited.add(node.val);
		Node newNode = new Node(node.val);
		map.put(node.val, newNode);
		List<Node> neighbors = node.neighbors;
		for (Node nei : neighbors) {
			if (!visited.contains(nei.val))
				dfs1(nei, map, visited);
		}
	}

	public static Node cloneGraph(Node node) {
		if (node == null)
			return null;
		Map<Integer, Node> map = new HashMap<>();
		Set<Integer> visited = new HashSet<>();
		dfs1(node, map, visited);
		visited.clear();
		dfs2(node, map, visited);
		return map.get(node.val);
	}

	public static void main(String[] args) {
		

	}

}
