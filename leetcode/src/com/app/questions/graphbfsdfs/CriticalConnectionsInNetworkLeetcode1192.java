package com.app.questions.graphbfsdfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CriticalConnectionsInNetworkLeetcode1192 {
	private static int[] low;
	
	private static void dfs(LinkedList<Integer>[] edges, int v, int parent, 
			int timer, boolean[] visited, List<List<Integer>> res) {
		visited[v] = true;
		low[v] = timer;
		
		LinkedList<Integer> nodes = edges[v];
		
		for(Integer node: nodes) {
			if(node == parent)
				continue;
			if(!visited[node])
				dfs(edges, node, v, timer + 1, visited, res);
			low[v] = Integer.min(low[v], low[node]);
			if(low[node] > timer) {
				res.add(Arrays.asList(v, node));
			}
		}
	}
	
	private static List<List<Integer>> criticalComponents(int n, List<List<Integer>> connections) {
		LinkedList<Integer>[] edges = new LinkedList[n];
		for(int i = 0; i < n; i++) {
			edges[i] = new LinkedList<>();
		}
		
		int e = connections.size();
		
		for(int i = 0; i < e; i++) {
			List<Integer> connection = connections.get(i);
			edges[connection.get(0)].add(connection.get(1));
			edges[connection.get(1)].add(connection.get(0));
		}
		
		List<List<Integer>> res = new ArrayList<>();
		
		boolean[] visited = new boolean[n];
		low = new int[n];		
		
		dfs(edges, 0, -1, 0, visited, res);
		
		return res;
	}

	public static void main(String[] args) {
		List<List<Integer>> connections = new ArrayList<>();
		List<Integer> conn1 = new ArrayList<>();
		conn1.add(0);
		conn1.add(1);
		connections.add(conn1);
		
		conn1 = new ArrayList<>();
		conn1.add(1);
		conn1.add(2);
		connections.add(conn1);
		
		conn1 = new ArrayList<>();
		conn1.add(2);
		conn1.add(0);
		connections.add(conn1);
		
		conn1 = new ArrayList<>();
		conn1.add(1);
		conn1.add(3);
		connections.add(conn1);
		
		conn1 = new ArrayList<>();
		conn1.add(3);
		conn1.add(4);
		connections.add(conn1);
		
		conn1 = new ArrayList<>();
		conn1.add(4);
		conn1.add(5);
		connections.add(conn1);
		
		conn1 = new ArrayList<>();
		conn1.add(5);
		conn1.add(3);
		connections.add(conn1);
		
		List<List<Integer>> res = criticalComponents(6, connections);
		System.out.println(res);
	}

}
