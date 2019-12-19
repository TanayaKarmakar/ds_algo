package com.app.recursion.practice;

public class TowerOfHanoiPractice {
	private static void towerOfHanoi(String source, String aux, String dest, int n) {
		if (n == 1) {
			System.out.println("Moving disc" + n + " from " + source + " to " + dest);
			return;
		}
		towerOfHanoi(source, dest, aux, n - 1);
		System.out.println("Moving disc" + n + " from " + source + " to " + dest);
		towerOfHanoi(aux, source, dest, n - 1);
	}

	public static void main(String[] args) {
		int n = 3;
		towerOfHanoi("a","b","c", n);
	}

}
