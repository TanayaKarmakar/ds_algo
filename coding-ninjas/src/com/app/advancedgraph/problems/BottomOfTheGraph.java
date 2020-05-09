package com.app.advancedgraph.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class BottomOfTheGraph {
	private static void dfs(LinkedList<Integer>[] edges, int start, Stack<Integer> stack, 
			Set<Integer> visited) {
		visited.add(start);
		LinkedList<Integer> nodes = edges[start];
		for(Integer node: nodes) {
			if(!visited.contains(node))
				dfs(edges, node, stack, visited);
		}
		stack.push(start);
	}
	
	private static void dfs2(LinkedList<Integer>[] edgesT, int start, TreeSet<Integer> component, Set<Integer> visited) {
		visited.add(start);
		component.add(start);
		
		LinkedList<Integer> nodes = edgesT[start];
		for(Integer node: nodes) {
			if(!visited.contains(node))
				dfs2(edgesT, node, component, visited);
		}
	}
	
	
	private static Set<TreeSet<Integer>> getSCC(LinkedList<Integer>[] edges, LinkedList<Integer>[] edgesT, 
			int nV) {
		Stack<Integer> stack = new Stack<>();
		Set<Integer> visited = new HashSet<>();
		for(int i = 0; i < nV; i++) {
			if(!visited.contains(i)) {
				dfs(edges, i, stack, visited);
			}
		}
		
		visited.clear();
		Set<TreeSet<Integer>> components = new HashSet<>();
		while(!stack.isEmpty()) {
			int node = stack.pop();
			if(!visited.contains(node)) {
				TreeSet<Integer> component = new TreeSet<>();
				dfs2(edgesT, node, component, visited);
				components.add(component);
			}
		}
		
		return components;
	}
	
	private static void printBottom(LinkedList<Integer>[] edges, LinkedList<Integer>[] edgesT, 
			int nV) {
		Set<TreeSet<Integer>> components = getSCC(edges, edgesT, nV);
		TreeSet<Integer> bottom = new TreeSet<>();
		
		//System.out.println(components);
		
		for(TreeSet<Integer> component: components) {
			boolean isBottom = true;
			
			//int bottomNode = -1;
			for(Integer el: component) {
				LinkedList<Integer> nodes = edges[el];
				for(Integer el1: nodes) {
					if(!component.contains(el1)) {
						isBottom = false;
						break;
					}
				}
				if(!isBottom)
					break;
			}
			if(isBottom) {
				for(Integer el1: component) {
					//System.out.print((el1 + 1) + " ");
					bottom.add(el1);
				}
			}
			
			//System.out.println();
		}
		for(Integer el: bottom) {
			System.out.print((el + 1) + " ");
		}
	}


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			int nV = scanner.nextInt();
			if(nV == 0)
				break;
			int nE = scanner.nextInt();
			LinkedList<Integer>[] edges = new LinkedList[nV];
			LinkedList<Integer>[] edgesT = new LinkedList[nV];
			for(int i = 0; i < nV; i++) {
				edges[i] = new LinkedList<Integer>();
				edgesT[i] = new LinkedList<Integer>();
			}
			
			int i = 0;
			while(i < nE) {
				int v1 = scanner.nextInt();
				int v2 = scanner.nextInt();
				edges[v1 - 1].add(v2 - 1);
				edgesT[v2 - 1].add(v1 - 1);
				i++;
			}
			printBottom(edges, edgesT, nV);
			
		}

		scanner.close();
	}

}
