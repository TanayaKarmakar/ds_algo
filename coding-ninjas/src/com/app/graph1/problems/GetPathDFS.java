package com.app.graph1.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetPathDFS {
	private static List<Integer> path = null;
	
	private static List<Integer> getPath(int[][] edges, boolean[] visited, int start, int end, int v) {
		visited[start] = true;
		for(int i = 0; i < v; i++) {
			if(edges[start][i] == 1) {
				if(i == end) {
					if(path == null) {
						path = new ArrayList<>();
						path.add(end);
						path.add(start);
					}
					return path;
				}
				else if(!visited[i]) {
					return getPath(edges, visited, i, end, v);
				}
			}
		}
		return path;
	}
	
	private static List<Integer> getPath(int[][] edges, int start, int end, int v) {
		boolean[] visited = new boolean[v];
		for(int i = 0; i < v; i++) {
			if(!visited[i] && i == start) {
				path = getPath(edges, visited, start, end, v);
				if(path != null && !path.isEmpty()) {
					if(path.get(path.size() - 1) != start) {
						path.add(start);
					}
					
					return path;
				}
			}
		}
		return null;
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
		
		if(path != null && !path.isEmpty()) {
			for(Integer el: path) {
				System.out.println(el + " ");
			}
		}
		
		System.out.println();
		
		scanner.close();

	}

}
