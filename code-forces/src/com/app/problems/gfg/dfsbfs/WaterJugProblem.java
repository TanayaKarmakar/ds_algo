package com.app.problems.gfg.dfsbfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

class Pair {
	int first;
	int second;

	public Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + first;
		result = prime * result + second;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (first != other.first)
			return false;
		if (second != other.second)
			return false;
		return true;
	}
}

public class WaterJugProblem {
	private static int numSteps(int a, int b, int d) {
		Queue<Pair> q = new LinkedList<>();
		Set<Pair> visited = new HashSet<>();
		int count = 0;
		
		q.add(new Pair(0, 0));
		q.add(null);
		visited.add(new Pair(0, 0));
		
		while(!q.isEmpty()) {
			Pair curr = q.poll();
			if(curr == null) {
				if(q.peek() != null)
					q.add(null);
				count++;
				continue;
			}
			
			
		}
		
		return 0;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int a = scanner.nextInt(); // max cap of jug1
		int b = scanner.nextInt(); // max cap of jug2
		int d = scanner.nextInt(); // measure water

		scanner.close();

	}

}
