package com.app.companywise.uber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node implements Comparable<Node> {
	String nodeName;
	boolean deleted;
	
	public Node(String nodeName, boolean deleted) {
		this.nodeName = nodeName;
		this.deleted = deleted;
	}

	@Override
	public int compareTo(Node o) {
		return this.nodeName.compareTo(o.nodeName);
	}
	
	public String toString() {
		return this.nodeName;
	}
	
}

public class ReconstructItinerary {
	private static void reconstructList(Map<String, List<Node>> adjList, 
			List<String> list, String current) {
		list.add(current);
		if(!adjList.containsKey(current))
			return;
		
		List<Node> nodeValues = adjList.get(current);
		for(Node node: nodeValues) {
			if(!node.deleted) {
				node.deleted = true;
				reconstructList(adjList, list, node.nodeName);
			}
		}
	}
	
	private static List<String> findItinerary(List<List<String>> tickets) {
		Map<String, List<Node>> adjList = new HashMap<>();
		
		for(List<String> ticket: tickets) {
			if(!adjList.containsKey(ticket.get(0))) {
				adjList.put(ticket.get(0), new ArrayList<>());
			}
			adjList.get(ticket.get(0)).add(new Node(ticket.get(1), false));
		}
		
		for(Map.Entry<String, List<Node>> entry: adjList.entrySet()) {
			Collections.sort(entry.getValue());
		}
		
		List<String> result = new ArrayList<>();
		reconstructList(adjList, result, "JFK");
		
		return result;
		
	}

	public static void main(String[] args) {
		List<List<String>> tickets = new ArrayList<>();
		List<String> ticket = new ArrayList<>();
		ticket.add("JFK");
		ticket.add("SFO");
		tickets.add(ticket);
		
		ticket = new ArrayList<>();
		ticket.add("JFK");
		ticket.add("ATL");
		tickets.add(ticket);
		
		ticket = new ArrayList<>();
		ticket.add("SFO");
		ticket.add("ATL");
		tickets.add(ticket);
		
		ticket = new ArrayList<>();
		ticket.add("ATL");
		ticket.add("JFK");
		tickets.add(ticket);
		
		ticket = new ArrayList<>();
		ticket.add("ATL");
		ticket.add("SFO");
		tickets.add(ticket);
		
		List<String> res = findItinerary(tickets);
		
		System.out.println(res);
	}

}
