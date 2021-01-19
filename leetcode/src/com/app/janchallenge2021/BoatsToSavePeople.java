package com.app.janchallenge2021;

import java.util.Arrays;

public class BoatsToSavePeople {
	private static int numRescueBoats(int[] people, int limit) {
		Arrays.sort(people);

		int start = 0;
		int end = people.length - 1;
		int count = 0;

		while (start < end) {
			if (people[start] + people[end] <= limit) {
				start++;
			} 
			count++;
			end--;
		}
		
		if(start == end)
			count++;

		return count;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 1, 2, 1, 2 };
		int limit = 5;

		int ans = numRescueBoats(arr, limit);

		System.out.println(ans);

	}

}
