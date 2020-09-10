package com.app.cpalgorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class DoubleProfiles {
	private static boolean isDouble(LinkedList<Integer> neighbors, int i, int j) {
		if(neighbors.size() == 0)
			return true;
		boolean isIFriend = false;
		boolean isJFriend = false;
		for(Integer nei: neighbors) {
			if(isIFriend && isJFriend)
				return true;
			if(nei == i)
				isIFriend = true;
			if(nei == j)
				isJFriend = true;
		}
		
		return (isIFriend & isJFriend);
	}
	
	private static int countDoubleProfiles(int[][] edges, LinkedList<Integer>[] edgeList, int n) {
		int e = edges.length;
		int count = 0;
		Set<Integer> visited = new HashSet<>();
		for(int i = 0; i < e; i++) {
			int v1 = edges[i][0];
			int v2 = edges[i][1];
			
			for(int j = 0; j < n; j++) {
				if(j != v1 && j != v2) {
					if(isDouble(edgeList[j], v1, v2)) {
						count++;
						visited.add(j);
					}
					break;
				}
			}
		}
		
		if(visited.size() < n) {
			for(int i = 0; i < n; i++) {
				if(!visited.contains(i)) {
					if(edgeList[i].size() == 0)
						count++;
				}
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		
		if(m == 0) {
			if(n <= 1)
				System.out.println(0);
			else
				System.out.println((n * (n - 1))/2);
		} else if(n == 2 && m == 1) {
			System.out.println(1);
		} else {
			int[][] edges = new int[m][2];
			LinkedList<Integer>[] edgeList = new LinkedList[n];
			for(int i = 0; i < n; i++) {
				edgeList[i] = new LinkedList<>();
			}
			
			for(int i = 0; i < m; i++) {
				int v1 = scanner.nextInt();
				int v2 = scanner.nextInt();
				edges[i][0] = v1 - 1;
				edges[i][1] = v2 - 1;
				edgeList[v1 - 1].add(v2 - 1);
				edgeList[v2 - 1].add(v1 - 1);
			}
			
			int ans = countDoubleProfiles(edges, edgeList, n);
			
			System.out.println(ans);
		}
		
		
		scanner.close();

	}

}
