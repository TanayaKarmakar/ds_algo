package com.app.problems.hackerearth.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class SocialNetworkingGraph {
	private static int findNumNodesAtDistance(LinkedList<Integer>[] edges, int start, int dist) {
		Set<Integer> visited = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		q.add(null);
		
		visited.add(start);
		int count = 0;
		while(!q.isEmpty()) {
			Integer curr = q.poll();
			if(curr == null) {
				count++;
				if(count == dist)
					return q.size();
				if(q.peek() != null)
					q.add(null);
				continue;
			}
			LinkedList<Integer> nodes = edges[curr];
			
			for(Integer el: nodes) {
				if(!visited.contains(el)) {
					q.add(el);
					visited.add(el);
				}
			}
		}
		
		return 0;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int e = scanner.nextInt();
		
		LinkedList<Integer>[] edges = new LinkedList[n + 1];
		for(int i = 0; i <= n; i++) {
			edges[i] = new LinkedList<>();
		}
		
		for(int i = 0; i < e; i++) {
			int v1 = scanner.nextInt();
			int v2 = scanner.nextInt();
			edges[v1].add(v2);
			edges[v2].add(v1);
		}
		
		int nQueries = scanner.nextInt();
		while(nQueries-- > 0) {
			int start = scanner.nextInt();
			int dist = scanner.nextInt();
			int ans = findNumNodesAtDistance(edges, start, dist);
			System.out.println(ans);
		}
		
		scanner.close();

	}

}
