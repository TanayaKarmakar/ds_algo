package com.app.advancedgraph.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

class Edge {
	int x;
	int y;
	int val;
	
	public Edge(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}
	
	public String toString() {
		return this.x + " " + this.y;
	}
}

public class FillTheMatrix {
	private static int parent[];
	
	private static int find(int x) {
		if(parent[x] == x)
			return x;
		x = parent[x];
		return find(x);
	}
	
	private static void union(int x, int y) {
		int xParent = find(x);
		int yParent = find(y);
		if(xParent == yParent)
			return;
		// we will always make the minimum value vertex parent of the other vertex
		if(xParent < yParent) {
			parent[y] = xParent;
		} else {
			parent[x] = yParent;
		}
	}
	
	private static boolean isBiColorable(LinkedList<Integer>[] edges, int start) {
		Set<Integer>[] sets = new HashSet[2];
		sets[0] = new HashSet<>();
		sets[1] = new HashSet<>();
		sets[0].add(start);
		
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		
		while(!q.isEmpty()) {
			int node = q.poll();
			LinkedList<Integer> nodes = edges[node];
			int currentSet = sets[0].contains(node)? 0 : 1;
			for(int el: nodes) {
				if(!sets[0].contains(el) && !sets[1].contains(el)) {
					sets[1 - currentSet].add(el);
					q.add(el);
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
		while(nTestCases-- > 0) {
			int n = scanner.nextInt();
			parent = new int[n];
			for(int i = 0; i < n; i++) {
				parent[i] = i;
			}
			
			boolean flag = false;
			int q = scanner.nextInt();
			List<Edge> edges = new ArrayList<>();
			while(q-- > 0) {
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				int val = scanner.nextInt();
				if(val == 0) {
					union(x - 1, y - 1);
				} else {
					int xParent = find(x - 1);
					int yParent = find(y - 1);
					if(xParent != yParent) {
						edges.add(new Edge(x - 1, y - 1, val));
					} else {
						flag = true;
					}
				}
			}
			if(flag) {
				System.out.println("no");
				continue;
			}
			
			//System.out.println(edges);
			Map<Integer, Integer> vertexComponent = new HashMap<>();
			for(int i = 0; i < n; i++) {
				int comp = find(i);
				vertexComponent.put(i, comp);
			}
			
			//System.out.println(vertexComponent);
			Map<Integer, Integer> componentNode = new HashMap<>();
			int nodeNum = 0;
			for(Map.Entry<Integer, Integer> entry: vertexComponent.entrySet()) {
				int comp = entry.getValue();
				if(!componentNode.containsKey(comp)) {
					componentNode.put(comp, nodeNum++);
				}
			}
			
			LinkedList<Integer>[] adjacencyList = new LinkedList[componentNode.size()];
			for(int i = 0; i < componentNode.size(); i++) {
				adjacencyList[i] = new LinkedList<Integer>();
			}
			
			for(int i = 0; i < edges.size(); i++) {
				int x = edges.get(i).x;
				int y = edges.get(i).y;
				int src = componentNode.get(vertexComponent.get(x));
				int dest = componentNode.get(vertexComponent.get(y));
				adjacencyList[src].add(dest);
				adjacencyList[dest].add(src);
			}
			
			boolean isPossible = true;
            for(int i = 0; i < componentNode.size(); i++) {
              	isPossible = isBiColorable(adjacencyList, i);
                if(!isPossible) {
                    System.out.println("no");
                    break;
                }
            }
            if(isPossible) {
                System.out.println("yes");
            }
		
			//System.out.println(adjacencyList);
		}
		scanner.close();
	}

}
