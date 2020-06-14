package com.app.problems.hackerearth.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class MonkAndIslands {
	private static int findMinDist(LinkedList<Integer>[] edges, int n) {
		int count = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		q.add(null);
		
		Set<Integer> visited = new HashSet<>();
		visited.add(1);
		
		while(!q.isEmpty()) {
			Integer curr = q.poll();
			if(curr == null) {
				count++;
				if(q.peek() != null)
					q.add(null);
				continue;
			}
			
			if(curr == n)
				return count;
			
			LinkedList<Integer> nodes = edges[curr];
			for(Integer el: nodes) {
				if(!visited.contains(el)) {
					visited.add(el);
					q.add(el);
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		
		while(nTestCases-- > 0) {
			int n = scanner.nextInt();
			int e = scanner.nextInt();
			
			LinkedList<Integer>[] edges = new LinkedList[n + 1];
			for(int i = 1; i <= n; i++) {
				edges[i] = new LinkedList<>();
			}
			
			for(int i = 0; i < e; i++) {
				int v1 = scanner.nextInt();
				int v2 = scanner.nextInt();
				edges[v1].add(v2);
				edges[v2].add(v1);
			}
			
			int count = findMinDist(edges, n);
			System.out.println(count);
		}
		
		scanner.close();
	}

}
