package com.app.graph2.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
	int v1;
	int v2;
	int w;
	
	public Edge(int v1, int v2, int w) {
		this.v1 = v1;
		this.v2 = v2;
		this.w = w;
	}

	@Override
	public int compareTo(Edge o) {
		return this.w - o.w;
	}
	
	public String toString() {
		return Integer.min(this.v1, this.v2) + " " + Integer.max(this.v1, this.v2) + " " + this.w;
	}
}

public class KruskalsAlgorithm {
	private static int getParent(int v1, int[] parent) {
		if(parent[v1] == v1)
			return v1;
		v1 = parent[v1];
		return getParent(v1, parent);
	}
		
	private static List<Edge> getMST(List<Edge> edges, int nV, int nE) {
		int targetEdge = nV - 1;
		int[] parent = new int[nV];
		
		for(int i = 0; i < nV; i++) {
			parent[i] = i;
		}
		
		Collections.sort(edges);
		List<Edge> result = new ArrayList<>();
		
		int i = 0;
		int j = 0;
		while(i < targetEdge) {
			Edge currEdge = edges.get(j);
			int srcParent = getParent(currEdge.v1, parent);
			int destParent = getParent(currEdge.v2, parent);
			if(srcParent != destParent) {
				result.add(currEdge);
				parent[srcParent] = destParent;
				i++;
			}
			
			if(j == edges.size())
				break;
			j++;
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nV = scanner.nextInt();
		int nE = scanner.nextInt();
		
		List<Edge> edges = new ArrayList<>();
		int i = 0;
		while(i < nE) {
			int v1 = scanner.nextInt();
			int v2 = scanner.nextInt();
			int w = scanner.nextInt();
			Edge edge = new Edge(v1, v2, w);
			edges.add(edge);
			i++;
		}
		
		List<Edge> output = getMST(edges, nV, nE);
		for(Edge edge: output) {
			System.out.println(edge);
		}
		
		scanner.close();
	}

}
