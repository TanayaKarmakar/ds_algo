package com.app.nt2.problems;

import java.util.Arrays;
import java.util.Scanner;

public class EulerTotientFunction {
	private static int[] getPhiValues(int n) {
		int[] phi = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			phi[i] = i;
		}

		for (int i = 2; i <= n; i++) {
			if (phi[i] == i) {
				phi[i] = i - 1;
				int j = 2 * i;
				while (j <= n) {
					phi[j] = (phi[j] * (i - 1))/i;
					j += i;
				}
			}
		}
		
		return phi;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		
		int[] phi = getPhiValues(n);
		
		System.out.println(Arrays.toString(phi));
		
		scanner.close();

	}

}
