package com.app.problems.hackerearth.binarysearch;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class SherlockAndNumbers {
	private static int findPthSmallestNumber(int n, int p, Set<Integer> delSet) {
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		for(int i = 1; i <= n; i++) {
			if(!delSet.contains(i)) {
				pQ.add(i);
			}
		}
		
		while(!pQ.isEmpty() && p > 0) {
			int num = pQ.poll();
			p--;
			if(p == 0)
				return num;
		}
		
		return -1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		while(nTestCases-- > 0) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			int p = scanner.nextInt();
			Set<Integer> delSet = new HashSet<>();
			for(int i = 0; i < k; i++) {
				int num = scanner.nextInt();
				delSet.add(num);
			}
			
			int ans = findPthSmallestNumber(n, p, delSet);
			System.out.println(ans);
		}
		scanner.close();
	}

}
