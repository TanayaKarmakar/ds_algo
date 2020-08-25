package com.app.augustchallenge;

import java.util.Arrays;
import java.util.Scanner;

public class DistributeCandiesToPeople {
	private static int[] distributeCandies(int candies, int num_people) {
		int[] res = new int[num_people];
		
		int i = candies;
		int k = 0;
		boolean finished = false;
		while(i > 0) {
			for(int j = 0; j < num_people; j++) {
				int coeff = (k * num_people + (j + 1));
				if(i >= coeff) {
					res[j] += coeff;
					i -= coeff;
				} else {
					if(i >= 0) {
						res[j] += i;
						i = 0;
					}
					finished = true;
					break;
				}
			}
			k++;
			if(finished)
				break;
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nC = scanner.nextInt();
		int n = scanner.nextInt();
		int[] res = distributeCandies(nC, n);
		
		System.out.println(Arrays.toString(res));
		
		scanner.close();

	}

}
