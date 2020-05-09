package com.app.graph1.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetPathDFS {
	//private static List<Integer> path = null;
	
	private static boolean getPath(int[][] edges, int start, int end, int v, 
			List<Integer> path, boolean[] visited) {
		visited[start] = true;
		path.add(0, start);
		if(start == end) {
			return true;
		}
		for(int i = 0; i < v; i++) {
			if(edges[start][i] == 1 && !visited[i]) {
				if(getPath(edges, i, end, v, path, visited) == true) {
					return true;
				}
			}
		}
		
		path.remove(0);
		return false;
	}
	
	
	private static List<Integer> getPath(int[][] edges, int start, int end, int v) {
		boolean[] visited = new boolean[v];
		visited[start] = true;
		for(int i = 0; i < v; i++) {
			if(!visited[i] && edges[start][i] == 1) {
				List<Integer> path = new ArrayList<>();
				getPath(edges, i, end, v, path, visited);
				if(!path.isEmpty()) {
					path.add(start);
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

		List<Integer> path = getPath(edges, start, end, v);
		
		if(path != null && !path.isEmpty()) {
			for(Integer el: path) {
				System.out.print(el + " ");
			}
		}
		
		System.out.println();
		
		scanner.close();

	}

}
