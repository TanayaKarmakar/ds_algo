package com.app.questions.graphbfsdfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;


public class ReconstructItineraryLeetcode332 {
	private static void dfs(Map<String, PriorityQueue<String>> adjList, Stack<String> stack, String start) {
		while(adjList.containsKey(start) && adjList.get(start).size() > 0) {
			String nei = adjList.get(start).remove();
			dfs(adjList, stack, nei);
		}
		
		stack.push(start);
	}
	
	private static List<String> findItinerary(List<List<String>> tickets) {
		Map<String, PriorityQueue<String>> adjList = new HashMap<>();
		for(List<String> ticket: tickets) {
			String source = ticket.get(0);
			String destination = ticket.get(1);
			
			if(!adjList.containsKey(source))
				adjList.put(source, new PriorityQueue<>());
			adjList.get(source).add(destination);
		}
		
		Stack<String> stack = new Stack<>();
		dfs(adjList, stack, "JFK");
		
		List<String> result = new ArrayList<>();
		while(!stack.isEmpty()) {
			result.add(stack.pop());
		}
		
		return result;
	}

	public static void main(String[] args) {
		List<List<String>> routes = new ArrayList<>();
		routes.add(Arrays.asList("JFK", "SFO"));
		routes.add(Arrays.asList("JFK", "ATL"));
		routes.add(Arrays.asList("SFO", "ATL"));
		routes.add(Arrays.asList("ATL", "JFK"));
		routes.add(Arrays.asList("ATL", "SFO"));
		
		List<String> results = findItinerary(routes);
		System.out.println(results);
		
		routes = new ArrayList<>();
		routes.add(Arrays.asList("MUC", "LHR"));
		routes.add(Arrays.asList("JFK", "MUC"));
		routes.add(Arrays.asList("SFO", "SJC"));
		routes.add(Arrays.asList("LHR", "SFO"));
		
		results = findItinerary(routes);
		System.out.println(results);

	}

}
