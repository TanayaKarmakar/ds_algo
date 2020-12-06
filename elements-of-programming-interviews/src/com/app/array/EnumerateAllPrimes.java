package com.app.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnumerateAllPrimes {
	private static List<Integer> enumerateAllPrimes(int n) {
		boolean[] primeSieve = new boolean[n + 1];
		Arrays.fill(primeSieve, true);

		List<Integer> res = new ArrayList<>();
		for (int i = 2; (i * i) <= n; i++) {
			if (primeSieve[i]) {
				int j = i;
				while((i * j) <= n) {
					primeSieve[i * j] = false;
					j++;
				}
			}
		}

		for (int i = 2; i <= n; i++) {
			if (primeSieve[i])
				res.add(i);
		}

		return res;
	}

	public static void main(String[] args) {
		int n = 18;
		List<Integer> res = enumerateAllPrimes(n);

		System.out.println(res);
	}

}
