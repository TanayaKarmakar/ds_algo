package com.app.graph1.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class GetPathBFS {
	private static void getPath(int[][] edges, int start, int end, int v) {
		boolean[] visited = new boolean[v];
		Queue<Integer> q = new LinkedList<>();
		Map<Integer, Integer> map = new HashMap<>();
		
		q.add(start);
		visited[start] = true;
		
		int node = start;
		while(!q.isEmpty() && node != end) {
			node = q.poll();
//			if(node == end)
//				break;
			for(int i = 0; i < v; i++) {
				if(edges[node][i] == 1 && !visited[i]) {
					q.add(i);
					map.put(i, node);
					visited[i] = true;
				}
			}
		}
		
		int curr = end;
		while(curr != start) {
			if(map.get(curr) == null)
				break;
			System.out.print(curr + " ");
			curr = map.get(curr);
		}
		if(curr != end) {
			System.out.print(curr + " ");
		}
		
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int v = scanner.nextInt();
		int e = scanner.nextInt();
		int[][] edges = new int[v][v];

		for (int i = 0; i < e; i++) {
			int v1 = scanner.nextInt();
			int v2 = scanner.nextInt();

			edges[v1][v2] = 1;
			edges[v2][v1] = 1;
		}

		int start = scanner.nextInt();
		int end = scanner.nextInt();

		getPath(edges, start, end, v);
		scanner.close();

	}

}
