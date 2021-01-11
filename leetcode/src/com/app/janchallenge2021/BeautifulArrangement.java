package com.app.janchallenge2021;

import java.util.Scanner;

public class BeautifulArrangement {
	private static int count = 0;

	private static void doArrangement(int n, int pos, boolean[] visited) {
		if (pos > n) {
			count++;
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
				visited[i] = true;
				doArrangement(n, pos + 1, visited);
				visited[i] = false;
			}
		}
	}

	private static int countArrangement(int n) {
		count = 0;
		boolean[] visited = new boolean[n + 1];
		doArrangement(n, 1, visited);
		
		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		int ans = countArrangement(n);

		System.out.println(ans);

		scanner.close();

	}

}
