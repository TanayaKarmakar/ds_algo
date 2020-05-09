package com.app.advancedgraph.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class BipartiteGraph {
	private static boolean isBiColorable(LinkedList<Integer>[] edges, int nV) {
		Set<Integer>[] sets = new HashSet[2];
		sets[0] = new HashSet<>();
		sets[1] = new HashSet<>();
		
		sets[0].add(0);
		
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		
		while(!q.isEmpty()) {
			int node = q.poll();
			int currentSet = sets[0].contains(node) ? 0 : 1;
			LinkedList<Integer> nodes = edges[node];
			for(Integer el: nodes) {
				if(!sets[0].contains(el) && !sets[1].contains(el)) {
					q.add(el);
					sets[1 - currentSet].add(el);
				} else {
					if(sets[currentSet].contains(el))
						return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		
		while(nTestCases > 0) {
			int nV = scanner.nextInt();
			int nE = scanner.nextInt();
			
			LinkedList<Integer>[] edges = new LinkedList[nV];
			for(int i = 0; i < nV; i++) {
				edges[i] = new LinkedList<Integer>();
			}
			
			for(int i = 0; i < nE; i++) {
				int v1 = scanner.nextInt();
				int v2 = scanner.nextInt();
				edges[v1 - 1].add(v2 - 1);
				edges[v2 - 1].add(v1 - 1);
			}
			
			boolean isBipartite = isBiColorable(edges, nV);
			System.out.println(isBipartite ? "BICOLORABLE": "NON BICOLORABLE");
			nTestCases--;
		}
		
		scanner.close();
	}

}
