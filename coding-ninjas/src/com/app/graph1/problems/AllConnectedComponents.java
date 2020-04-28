package com.app.graph1.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class AllConnectedComponents {
	private static void traverse(int[][] edges, boolean[] visited, int sv, int v, List<Integer> components) {
		visited[sv] = true;
		components.add(sv);
		for(int i = 0; i < v; i++) {
			if(edges[sv][i] == 1 && !visited[i]) {
				traverse(edges, visited, i, v, components);
			}
		}
	}
	
	private static List<List<Integer>> connectedComponents(int[][] edges, int v) {
		List<List<Integer>> paths = new ArrayList<>();
		boolean[] visited = new boolean[v];
		for(int i = 0; i < v; i++) {
			if(!visited[i]) {
				List<Integer> components = new ArrayList<>();
				traverse(edges, visited, i, v, components);
				Collections.sort(components);
				paths.add(components);
			}
		}
		return paths;
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
		
		
		List<List<Integer>> paths = connectedComponents(edges, v);
		System.out.println(paths);
		for(List<Integer> components: paths) {
			for(Integer el: components) {
				System.out.print(el + " ");
			}
			System.out.println();
		}
		scanner.close();
	}

}
