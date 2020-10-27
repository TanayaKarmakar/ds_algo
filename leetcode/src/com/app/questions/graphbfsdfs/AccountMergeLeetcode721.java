package com.app.questions.graphbfsdfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AccountMergeLeetcode721 {
	private static Map<String, List<String>> createAdjacencyList(List<List<String>> accounts) {
		Map<String, List<String>> adjList = new HashMap<>();
		for (List<String> account : accounts) {
			List<String> emailList = account.subList(1, account.size());
			for (String email : emailList) {
				if (!adjList.containsKey(email)) {
					List<String> value = new ArrayList<>();
					value.add(account.get(0));
					adjList.put(email, value);
				}
			}

			for (String email1 : emailList) {
				for (String email2 : emailList) {
					if (!email1.equals(email2)) {
						adjList.get(email1).add(email2);
					}
				}
			}
		}
		return adjList;
	}
	
	private static void dfs(String key, Map<String, List<String>> adjList, Set<String> visited, 
			List<String> account) {
		account.add(key);
		visited.add(key);
		
		List<String> values = adjList.get(key).subList(1, adjList.get(key).size());
		for(String value: values) {
			if(!visited.contains(value))
				dfs(value, adjList, visited, account);
		}
	}
	
	private static List<List<String>> accountsMerge(List<List<String>> accounts) {
		List<List<String>> res = new ArrayList<>();
		Set<String> visited = new HashSet<>();
		
		Map<String, List<String>> adjList = createAdjacencyList(accounts);
		
		System.out.println(adjList);
		
		for(Map.Entry<String, List<String>> entry: adjList.entrySet()) {
			if(!visited.contains(entry.getKey())) {
				List<String> account = new ArrayList<>();
				dfs(entry.getKey(), adjList, visited, account);
				Collections.sort(account);
				account.add(0, entry.getValue().get(0));
				res.add(account);
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		List<List<String>> accounts = new ArrayList<>();
		List<String> account1 = new ArrayList<>();
		account1.add("John");
		account1.add("johnsmith@mail.com");
		account1.add("john00@mail.com");
		accounts.add(account1);
		
		List<String> account2 = new ArrayList<>();
		account2.add("John");
		account2.add("johnnybravo@mail.com");
		accounts.add(account2);
		
		List<String> account3 = new ArrayList<>();
		account3.add("John");
		account3.add("johnsmith@mail.com");
		account3.add("john_newyork@mail.com");
		accounts.add(account3);
		
		List<String> account4 = new ArrayList<>();
		account4.add("Mary");
		account4.add("mary@mail.com");
		accounts.add(account4);
		
		List<List<String>> result = accountsMerge(accounts);
		
		System.out.println(result);
	}

}
