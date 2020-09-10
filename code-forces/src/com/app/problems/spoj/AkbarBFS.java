package com.app.problems.spoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class AkbarBFS {
	
	private static void bfs(Map<Integer, List<Integer>> adjList, int[] strength, Set<Integer> visited) {
		Queue<Integer> q = new LinkedList<>();
		q.add(strength[0]);
		q.add(null);
		
		int count = strength[1];
		
		while(!q.isEmpty()) {
			Integer curr = q.poll();
			if(curr == null) {
				count--;
				if(count == 0)
					return;
				if(q.peek() != null)
					q.add(null);
				continue;
			}
			
			List<Integer> edges = adjList.get(curr);
			
			for(Integer edge: edges) {
				if(!visited.contains(edge)) {
					q.add(edge);
					visited.add(edge);
				}
			}
		}
	}
	
	private static boolean isOptimal(Map<Integer, List<Integer>> adjList, int n, int[][] strength) {
		Arrays.sort(strength, (e1, e2) -> e2[1] - e1[1]);
		
		Set<Integer> visited = new HashSet<>();
		for(int i = 0; i < strength.length; i++) {
			int[] curr = strength[i];
			int strengthVal = curr[1];
			int soldier = curr[0];
			if(strengthVal == 0) {
				if(!visited.contains(soldier))
					visited.add(soldier);
			} else {
				bfs(adjList, curr, visited);
			}
			
			if(i < strength.length && visited.size() == n)
				return false;
			
		}
		
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		while(nTestCases-- > 0) {
			int n = scanner.nextInt();
			int r = scanner.nextInt();
			int m = scanner.nextInt();
			
			Map<Integer, List<Integer>> adjList 
			= new HashMap<>();
			
			for(int i = 0; i < r; i++) {
				int v1 = scanner.nextInt();
				int v2 = scanner.nextInt();
				
				if(!adjList.containsKey(v1)) {
					List<Integer> edges = new ArrayList<>();
					edges.add(v2);
					adjList.put(v1, edges);
				} else {
					adjList.get(v1).add(v2);
				}
				
				if(!adjList.containsKey(v2)) {
					List<Integer> edges = new ArrayList<>();
					edges.add(v1);
					adjList.put(v2, edges);
				} else {
					adjList.get(v2).add(v1);
				}
			}
			
			int[][] strengthMat = new int[m][2];
			
			for(int i = 0; i < m; i++) {
				int num1 = scanner.nextInt();
				int num2 = scanner.nextInt();
				strengthMat[i] = new int[] {num1, num2};
			}
			
			boolean isOptimal = isOptimal(adjList, n, strengthMat);
			
			if(isOptimal) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}

		scanner.close();
	}

}
