package com.app.queue.classroom;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateNumbersWithGivenDigits {
	private static void generateNumbers(int n) {
		// generate numbers with digit 5 and 6
		Queue<String> q = new LinkedList<>();
		q.add("5");
		q.add("6");
		for (int count = 0; count < n; count++) {
			String curr = q.remove();
			System.out.print(curr + " ");
			q.add(curr + "5");
			q.add(curr + "6");
		}
	}

	public static void main(String[] args) {
		generateNumbers(10);

	}

}
