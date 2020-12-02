package com.app.cpalgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//check whether an undirected graph has eulerian path or eulerain circuit
public class EulerianPathAndCircuit {
	private static final int EULERIAN_PATH = 1;
	private static final int EULERIAN_CIRCUIT = 2;
	private static final int NONE = 0;

	private static int eulerianPathOrCircuit(Map<Integer, List<Integer>> adjList, int N) {
		int oddDegCount = 0;

		for (int i = 0; i < N; i++) {
			List<Integer> edges = adjList.get(i);
			if (edges.size() % 2 != 0) {
				oddDegCount++;
			}
		}

		if (oddDegCount == 0)
			return EULERIAN_CIRCUIT; // Eulerian
		else if (oddDegCount == 2)
			return EULERIAN_PATH; // Semi Eulerian
		else
			return NONE;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int nVertices = scanner.nextInt();
		int nEdges = scanner.nextInt();

		Map<Integer, List<Integer>> adjList = new HashMap<>();

		for (int i = 0; i < nEdges; i++) {
			int s = scanner.nextInt();
			int d = scanner.nextInt();

			if (!adjList.containsKey(s))
				adjList.put(s, new ArrayList<>());

			adjList.get(s).add(d);

			if (!adjList.containsKey(d))
				adjList.put(d, new ArrayList<>());

			adjList.get(d).add(s);
		}
		
		int ans = eulerianPathOrCircuit(adjList, nVertices);
		
		if(ans == 2)
			System.out.println("Eulerian");
		else if(ans == 1)
			System.out.println("Semi Eulerian");
		else
			System.out.println("Non Eulerian");

		scanner.close();
	}

}
