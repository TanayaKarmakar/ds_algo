package com.app.searchsort.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//Problem statement -
//Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. 
//The stalls are located along a straight line at positions x1,...,xN 
//(0 <= xi <= 1,000,000,000).
//His C (2 <= C <= N) cows don't like this barn layout and become 
//aggressive towards each other once put into a stall. To prevent the cows from 
//hurting each other, FJ wants to assign the cows to the stalls, such that the
//minimum distance between any two of them is as large as possible. What is the 
//largest minimum distance?
public class AggressiveCows {
	private static boolean isArrangementPossible(long[] stalls, int nStalls, int nCows, long minDist) {
		long currDist = stalls[0];
		int count = 1;
		for (int i = 1; i < nStalls; i++) {
			if(stalls[i] - currDist >= minDist) {
				count++;
				
				if(count == nCows)
					return true;
				currDist = stalls[i];
			}
		}
		return false;
	}

	private static long largestMinDistance(long[] stalls, int nStalls, int nCows) {
		Arrays.sort(stalls);
		long minDistance = 0;
		long maxDistance = stalls[nStalls - 1] - stalls[0];
		long res = 0;
		while (minDistance <= maxDistance) {
			long mid = minDistance + (maxDistance - minDistance)/2;
			if(isArrangementPossible(stalls, nStalls, nCows, mid)) {
				res = mid;
				minDistance = mid + 1;
			} else {
				maxDistance = mid - 1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = Integer.parseInt(scanner.nextLine());
		List<Long> res = new ArrayList<>();
		while (nTestCases > 0) {
			String dimensions = scanner.nextLine();

			int nStalls = Integer.parseInt(dimensions.split("\\s+")[0]);
			int nCows = Integer.parseInt(dimensions.split("\\s+")[1]);
			long[] stalls = new long[nStalls];

			for (int i = 0; i < nStalls; i++) {
				stalls[i] = scanner.nextLong();
			}

			long result = largestMinDistance(stalls, nStalls, nCows);
			//System.out.println(result);
			res.add(result);
			nTestCases--;
		}
		
		for(Long el: res) {
			System.out.println(el);
		}

		scanner.close();

	}

}
