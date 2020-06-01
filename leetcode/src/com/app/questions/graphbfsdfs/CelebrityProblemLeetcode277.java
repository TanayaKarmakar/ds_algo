package com.app.questions.graphbfsdfs;

import java.util.Scanner;

public class CelebrityProblemLeetcode277 {
	int[][] people;
	
	public CelebrityProblemLeetcode277(int n) {
		people = new int[n][n];
		for(int i = 0; i < n; i++) {
			people[i][i] = 1;
		}
	}	
	
	private boolean knows(int n1, int n2) {
		return people[n1][n2] == 1;
	}
	
	private int findCelebrity(int n) {
		int[] outDeg = new int[n];
		int[] inDeg = new int[n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(j != i) {
					if(knows(i, j)) {
						outDeg[i]++;
						inDeg[j]++;
					}
				}
			}
		}
		
		int label = -1;
		for(int i = 0; i < n; i++) {
			if(inDeg[i] == n - 1 && outDeg[i] == 0) {
				label = i;
				break;
			}	
		}
		return label;
	}
	
	private void addEdge(int n1, int n2) {
		people[n1][n2] = 1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		CelebrityProblemLeetcode277 obj = new CelebrityProblemLeetcode277(n);
		for(int i = 0; i < n; i++) {
			int n1 = scanner.nextInt();
			int n2 = scanner.nextInt();
			obj.addEdge(n1, n2);
		}

		int label = obj.findCelebrity(n);
		
		System.out.println(label);
		
		scanner.close();
	}

}
