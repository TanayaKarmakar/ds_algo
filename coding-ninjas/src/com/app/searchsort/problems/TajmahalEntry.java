package com.app.searchsort.problems;

import java.util.Arrays;
import java.util.Scanner;

public class TajmahalEntry {
	private static int getWindow(int[] nums, int n) {
		int aux[] = new int[n];

		for (int i = 0; i < n; i++) {
			int v = (nums[i] - i) / n;
			if ((nums[i] - i) % n != 0) {
				v++;
			}
			//System.out.print(v + " ");
			aux[i] = (i + v * n);
		}
		//System.out.println();

		int window = -1;
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (aux[i] >= nums[i]) {
				if(res > aux[i]) {
					res = aux[i];
					window = i;
				}
			}
				
		}
//		System.out.println(Arrays.toString(nums));
//		System.out.println(Arrays.toString(aux));

		return window;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nDim = scanner.nextInt();

		int[] nums = new int[nDim];
		for (int i = 0; i < nDim; i++) {
			nums[i] = scanner.nextInt();
		}
		
		int window = getWindow(nums, nDim);
		
		System.out.println(window + 1);
		scanner.close();
	}

}
