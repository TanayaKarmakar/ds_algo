package com.app.problems.gfg.dfsbfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class AllPossiblePathsBetweenTwoNodes {
	private static boolean isFormingCycle(List<Integer> path, int v) {
		for(Integer e: path) {
			if(e == v)
				return true;
		}
		return false;
	}
	
	private static List<List<Integer>> getAllPaths(LinkedList<Integer>[] edges, int start, int end) {
		Queue<List<Integer>> q = new LinkedList<>();
		List<Integer> path = new ArrayList<>();
		path.add(start);
		q.add(path);
		
		List<List<Integer>> res = new ArrayList<>();
		while(!q.isEmpty()) {
			List<Integer> currPath = q.poll();
			
			if(currPath.get(currPath.size() - 1) == end) {
				res.add(currPath);
				continue;
			}
				
			int lastV = currPath.get(currPath.size() - 1);
			LinkedList<Integer> neighbors = edges[lastV];
			for(Integer nei: neighbors) {
				if(!isFormingCycle(currPath, nei)) {
					List<Integer> newPath = new ArrayList<>(currPath);
					newPath.add(nei);
					q.add(newPath);
				}	
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int e = scanner.nextInt();
		
		LinkedList<Integer>[] edges = new LinkedList[n];
		for(int i = 0; i < n; i++) {
			edges[i] = new LinkedList<>();
		}
		
		for(int i = 0; i < e; i++) {
			int v1 = scanner.nextInt();
			int v2 = scanner.nextInt();
			
			edges[v1].add(v2);
		}
		
		int start = scanner.nextInt();
		int end = scanner.nextInt();
		
		List<List<Integer>> res = getAllPaths(edges, start, end);
		
		System.out.println(res);
		
		scanner.close();
	}
}
