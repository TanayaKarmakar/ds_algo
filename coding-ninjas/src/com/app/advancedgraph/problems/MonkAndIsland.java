package com.app.advancedgraph.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class MonkAndIsland {
	private static int getMinPath(LinkedList<Integer>[] edges, int nV) {
		int[] level = new int[nV];
		Arrays.fill(level, Integer.MAX_VALUE);
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		Set<Integer> visited = new HashSet<>();
		
		level[0] = 0;
		while(!q.isEmpty()) {
			int node = q.poll();
			visited.add(node);
			if(node == nV - 1)
				return level[nV - 1];
			LinkedList<Integer> nodes = edges[node];
			for(int el: nodes) {
				if(!visited.contains(el)) {
					level[el] = Integer.min(level[node] + 1, level[el]);
					q.add(el);
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		while(nTestCases-- > 0) {
			int nV = scanner.nextInt();
			int nE = scanner.nextInt();
			
			LinkedList<Integer>[] edges = new LinkedList[nV];
			for(int i = 0; i < nV; i++) {
				edges[i] = new LinkedList<Integer>();
			}
			
			int i = 0;
			while(i < nE) {
				int v1 = scanner.nextInt();
				int v2 = scanner.nextInt();
				
				edges[v1 - 1].add(v2 - 1);
				edges[v2 - 1].add(v1 - 1);
				i++;
			}
			
			int minPath = getMinPath(edges, nV);
			System.out.println(minPath);
		}
		scanner.close();
	}

}
