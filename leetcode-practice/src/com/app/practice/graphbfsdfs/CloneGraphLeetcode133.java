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
	private static void dfs1(Node node, Set<Integer> visited, Map<Node, Node> nodeMap) {
		Node newNode = new Node(node.val);
		visited.add(node.val);
		nodeMap.put(node, newNode);
		
		List<Node> neighbors = node.neighbors;
		for(Node nei: neighbors) {
			if(!visited.contains(nei.val)) {
				dfs1(nei, visited, nodeMap);
			}
		}
	}
	
	private static void dfs2(Node node, Set<Integer> visited, Map<Node, Node> nodeMap) {
		visited.add(node.val);
		List<Node> neighbors = node.neighbors;
		for(Node nei: neighbors) {
			nodeMap.get(node).neighbors.add(nodeMap.get(nei));
		}
		
		for(Node nei: neighbors) {
			if(!visited.contains(nei.val)) {
				dfs2(nei, visited, nodeMap);
			}
		}
	}
	
	private static Node cloneGraph(Node node) {
		if(node == null)
			return null;
		if(node.neighbors.size() == 0)
			return new Node(node.val);
		Map<Node, Node> nodeMap = new HashMap<>();
		//map all node with new copy
		Set<Integer> visited = new HashSet<>();
		dfs1(node, visited, nodeMap);
		
		visited.clear();
		
		dfs2(node, visited, nodeMap);
		
		/*for(Map.Entry<Node, Node> entry: nodeMap.entrySet()) {
			List<Node> newNeighbors = new ArrayList<>();
			Node origNode = entry.getKey();
			for(Node origNei: origNode.neighbors) {
				newNeighbors.add(nodeMap.get(origNei));
			}
			Node newNode = entry.getValue();
			newNode.neighbors = newNeighbors;
			nodeMap.put(origNode, newNode);
		}*/
		return nodeMap.get(node);
	}

	public static void main(String[] args) {
		

	}

}
