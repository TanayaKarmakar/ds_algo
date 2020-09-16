package com.app.practice.graphbfsdfs;

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
	private static void dfs2(Map<Integer, Node> map, Node node, Set<Integer> visited) {
		List<Node> neighbors = node.neighbors;
		Node newNode = map.get(node.val);
		visited.add(node.val);
		for(Node nei: neighbors) {
			Node newNei = map.get(nei.val);
			newNode.neighbors.add(newNei);
		}
		
		for(Node nei: neighbors) {
			if(!visited.contains(nei.val))
				dfs2(map, nei, visited);
		}
	}
	
	private static void dfs1(Map<Integer, Node> map, Node node, Set<Integer> visited) {
		Node newNode = new Node(node.val);
		map.put(node.val, newNode);
		visited.add(node.val);
		
		List<Node> neighbors = node.neighbors;
		for(Node nei: neighbors) {
			if(!visited.contains(nei.val))
				dfs1(map, nei, visited);
		}
	}
	
	private static Node cloneGraph(Node node) {
		Map<Integer, Node> map = new HashMap<>();
		
		Set<Integer> visited = new HashSet<>();
		
		dfs1(map, node, visited);
		
		visited.clear();
		
		dfs2(map, node, visited);
		
		return map.get(node.val);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
