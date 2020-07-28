package com.app.problems.gfg.dfsbfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class ShortestPathToReachOnePrimeToAnother {
	private static boolean isPrime(int num) {
		int sqrtNum = (int)Math.sqrt(num);
		
		for(int i = 2; i <= sqrtNum; i++) {
			if(num % i == 0)
				return false;
		}
		return true;
	}
	
	private static int shortestPath(String prime1, String prime2) {
		if(prime1.equals(prime2))
			return 0;
		Queue<String> q = new LinkedList<>();
		q.add(prime1);
		q.add(null);
		
		int count = 1;
		Set<String> visited = new HashSet<>();
		visited.add(prime1);
		
		while(!q.isEmpty()) {
			String curr = q.poll();
			
			if(curr == null) {
				if(q.peek() != null)
					q.add(null);
				count++;
				continue;
			}
			
			if(curr.equals(prime2)) {
				return count;
			}
				
			
			for(int i = 0; i < curr.length(); i++) {
				for(int j = 0; j <= 9; j++) {
					String newStr = "";
					if(i == 0) {
						newStr = j + curr.substring(i + 1);
					} else if(i == curr.length() - 1) {
						newStr = curr.substring(0, i) + j;
					} else {
						newStr = curr.substring(0, i) + j + curr.substring(i + 1);
					}
					if(!visited.contains(newStr) && isPrime(Integer.parseInt(newStr))) {
						visited.add(newStr);
						q.add(newStr);
					}
				}
			}
		}
		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int prime1 = scanner.nextInt();
		int prime2 = scanner.nextInt();
		
		int ans = shortestPath(String.valueOf(prime1), String.valueOf(prime2));

		System.out.println(ans);
		scanner.close();
	}

}
