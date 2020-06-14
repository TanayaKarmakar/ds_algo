package com.app.problems.hackerearth.bfs;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class TheFlightPlan {
	private static void minCostPath(LinkedList<Integer>[] edges, int start, int end) {
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		Set<Integer> visited = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		q.add(null);
		
		visited.add(start);
		while(!q.isEmpty()) {
			Integer curr = q.poll();
			if(curr == null) {
				count++;
				if(q.peek() != null)
					q.add(null);
				continue;
			}
			if(curr == end) {
				count++;
				break;
			}
				
			LinkedList<Integer> nodes = edges[curr];
			for(Integer el: nodes) {
				if(!visited.contains(el)) {
					q.add(el);
					visited.add(el);
					map.put(el, curr);
				}
			}
		}
		
		int node = end;
		String str = "";
		while(node != start) {
			str = node + " " + str;
			node = map.get(node);
		}
		
		str = node + " " + str;
		
		System.out.println(count);
		System.out.println(str);
		
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int t = scanner.nextInt();
		int c = scanner.nextInt();
		
		LinkedList<Integer>[] edges = new LinkedList[n + 1];
		for(int i = 1; i <= n; i++) {
			edges[i] = new LinkedList<>();
		}

		for(int i = 0; i < m; i++) {
			int n1 = scanner.nextInt();
			int n2 = scanner.nextInt();
			edges[n1].add(n2);
			edges[n2].add(n1);
		}
		
		for(int i = 1; i <= n; i++) {
			Collections.sort(edges[i]);
		}
		
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		
		minCostPath(edges, x, y);
		
		scanner.close();
	}

}
