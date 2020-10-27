package com.app.questions.graphbfsdfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BusRoutesLeetcode815 {
	private static int numBusesToDestination(int[][] routes, int S, int T) {
		Map<Integer, Set<Integer>> routeMap = new HashMap<>();
		Set<Integer> visitedRoute = new HashSet<>();
		Set<Integer> visitedStop = new HashSet<>();
		
		for(int i = 0; i < routes.length; i++) {
			for(int j = 0; j < routes[i].length; j++) {
				routeMap.putIfAbsent(routes[i][j], new HashSet<>());
				routeMap.get(routes[i][j]).add(i);
			}
		}
		
		int cnt = 0;
		Queue<Integer> q = new LinkedList<>();
		
		q.add(S);
		
		while(!q.isEmpty()) {
			int size = q.size();
		
			for(int i = 0; i < size; i++) {
				int curr = q.poll();
				if(curr == T)
					return cnt;
				visitedStop.add(curr);
				
				for(int currentRoute: routeMap.get(curr)) {
					if(visitedRoute.contains(currentRoute))
						continue;
					visitedRoute.add(currentRoute);
					
					for(int currentStop: routes[currentRoute]) {
						if(visitedStop.contains(currentStop))
							continue;
						q.add(currentStop);
					}
				}
			}
			cnt++;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[][] routes = { { 24 }, { 3, 6, 11, 14, 22 }, { 1, 23, 24 }, { 0, 6, 14 }, { 1, 3, 8, 11, 20 } };
		int S = 20;
		int T = 8;

		int ans = numBusesToDestination(routes, S, T);

		System.out.println(ans);

	}

}
