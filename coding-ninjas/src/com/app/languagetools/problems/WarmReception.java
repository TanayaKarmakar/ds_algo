package com.app.languagetools.problems;

import java.util.Arrays;
import java.util.Scanner;

public class WarmReception {
	private static int getMaxCount(int[] arrivals, int[] departures, int n) {
		int i = 0;
		int j = 0;
		int count = 0;
		int res = Integer.MIN_VALUE;
		
		Arrays.sort(arrivals);
		Arrays.sort(departures);
		
		while(i < n && j < n) {
			if(arrivals[i] < departures[j]) {
				i++;
				count++;
				res = Integer.max(res, count);
			} else {
				j++;
				count--;
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nDim = Integer.parseInt(scanner.nextLine());

		int[] arrivals = new int[nDim];
		int[] departures = new int[nDim];

		String arrivalStr = scanner.nextLine();
		String departureStr = scanner.nextLine();

		String[] arrivalStrArr = arrivalStr.split("\\s+");
		String[] departureStrArr = departureStr.split("\\s+");
		for (int i = 0; i < nDim; i++) {
			arrivals[i] = Integer.parseInt(arrivalStrArr[i]);
			departures[i] = Integer.parseInt(departureStrArr[i]);
		}

		int count = getMaxCount(arrivals, departures, nDim);
		System.out.println(count);
		scanner.close();
	}

}
