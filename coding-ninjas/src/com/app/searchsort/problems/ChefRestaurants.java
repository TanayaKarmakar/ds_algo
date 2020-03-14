package com.app.searchsort.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

class Pair implements Comparable<Pair>{
	int val1;
	int val2;
	
	public Pair(int val1, int val2) {
		this.val1 = val1;
		this.val2 = val2;
	}

	@Override
	public int compareTo(Pair o) {
		if(this.val1 < o.val1)
			return -1;
		else if(this.val1 > o.val1)
			return 1;
		else
			return 0;
	}
}

public class ChefRestaurants {
	private static int getWaitingTime(Pair[] timings, int inTime, int len) {
		int low = 0;
		int high = len - 1;
		while(low <= high) {
			int mid = low + (high - low)/2;
			Pair currPair = timings[mid];
			if(inTime >= currPair.val1 && inTime < currPair.val2)
				return 0;
			else if(inTime >= currPair.val2) {
				if(mid + 1 < len) {
					currPair = timings[mid + 1];
					if(currPair.val1 > inTime)
						return (currPair.val1 - inTime);
					else
						low = mid + 1;
				} else
					return -1;
			} else if(inTime < currPair.val1) {
				if(mid == 0)
					return timings[mid].val1 - inTime;
				else if(mid - 1 >= 0) {
					currPair = timings[mid - 1];
					if(inTime >= currPair.val1 && inTime < currPair.val2)
						return 0;
					else
						high = mid - 1;
				}
			}
		}
		
		return -1;
	}

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nTestCases = scanner.nextInt();
		//int nTestCases = br.read();
		
		while(nTestCases > 0) {
			//String inputDims = scanner.nextLine();
			int nTime = scanner.nextInt();
			int nInTime = scanner.nextInt();
//			int nTime = br.read();
//			int nInTime = br.read();
			Pair[] timings = new Pair[nTime];
			for(int i = 0;i<nTime;i++) {
				int val1 = scanner.nextInt();
				int val2 = scanner.nextInt();
//				int val1 = br.read();
//				int val2 = br.read();
				timings[i] = new Pair(val1, val2);
			}
			
			Arrays.sort(timings);
			while(nInTime > 0) {
				int inTime = scanner.nextInt();
				//int inTime = br.read();
				System.out.println(getWaitingTime(timings, inTime, nTime));
				nInTime--;
			}
			nTestCases--;
		}
		scanner.close();
	}

}
