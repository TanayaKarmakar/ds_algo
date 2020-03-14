package com.app.searchsort.problems;

import java.util.Scanner;

public class MomosMarket {
	private static int determineMax(int []prefix, int query) {
		int low = 0;
		int high = prefix.length - 1;
		while(low < high) {
			int mid = low + (high - low)/2;
			if(prefix[mid] == query)
				return mid;
			else if(prefix[mid] > query) {
				if(mid - 1 >= 0 && prefix[mid - 1] <= query)
					return mid - 1;
				else {
					high = mid - 1;
				}					
			} else {
				if(mid + 1 < prefix.length && prefix[mid + 1] > query)
					return mid;
				else
					low = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nDim = scanner.nextInt();
		int[] shops = new int[nDim];

		for (int i = 0; i < nDim; i++) {
			shops[i] = scanner.nextInt();
		}

		int[] prefix = new int[nDim];
		prefix[0] = shops[0];
		for (int i = 1; i < nDim; i++) {
			prefix[i] = prefix[i - 1] + shops[i];
		}
		
		int queries = scanner.nextInt();
		while(queries > 0) {
			int currQuery = scanner.nextInt();
			int maxIndx = determineMax(prefix, currQuery);
			int remaining = maxIndx == -1 ? currQuery : (currQuery - prefix[maxIndx]);
			System.out.println((maxIndx + 1) + " " + remaining);
			queries--;
		}

		scanner.close();
	}

}
