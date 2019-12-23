package com.app.hashing.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstRepeatingElement {
	private static int[] createArray(String arrStr, int nDim) {
		int[] arr = new int[nDim];
		int indx = 0;
		for (String el : arrStr.split("\\s+")) {
			arr[indx++] = Integer.parseInt(el);
		}
		return arr;
	}

	private static int firstRepeatingElement(int[] arr, int nDim) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nDim; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			} else {
				int tmp = map.get(arr[i]);
				map.put(arr[i], ++tmp);
			}
		}

		for (int i = 0; i < nDim; i++) {
			int tmp = map.get(arr[i]);
			if (tmp > 1) {
				return (i + 1);
			}
		}
		return -1;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nTestCases = Integer.parseInt(br.readLine());
		List<Integer> res = new ArrayList<>();

		while (nTestCases > 0) {
			int nDim = Integer.parseInt(br.readLine());
			String str = br.readLine();
			int[] arr = createArray(str, nDim);
			res.add(firstRepeatingElement(arr, nDim));
			nTestCases--;
		}

		for (Integer el : res) {
			System.out.println(el);
		}

	}

}
