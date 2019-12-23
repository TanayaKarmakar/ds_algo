package com.app.hashing.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoArrays {
	private static int[] createArray(String strArr, int nDim) {
		int[] arr = new int[nDim];
		int cnt = 0;
		for (String el : strArr.split("\\s+")) {
			arr[cnt++] = Integer.parseInt(el);
		}
		return arr;
	}

	private static int intersectionCount(int[] arr1, int[] arr2) {
		Set<Integer> numSet = new HashSet<>();
		int n = arr1.length;
		int m = arr2.length;

		for (int i = 0; i < n; i++) {
			numSet.add(arr1[i]);
		}

		int count = 0;
		for (int i = 0; i < m; i++) {
			if (numSet.contains(arr2[i])) {
				count++;
				numSet.remove(arr2[i]);
			}
		}
		return count;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nTestCases = Integer.parseInt(br.readLine());
		List<Integer> res = new ArrayList<>();

		while (nTestCases > 0) {
			String nDimStr = br.readLine();
			int nDim1 = Integer.parseInt(nDimStr.split("\\s+")[0]);
			int nDim2 = Integer.parseInt(nDimStr.split("\\s+")[1]);
			String strArr1 = br.readLine();
			int[] arr1 = createArray(strArr1, nDim1);

			String strArr2 = br.readLine();
			int[] arr2 = createArray(strArr2, nDim2);
			res.add(intersectionCount(arr1, arr2));
			nTestCases--;
		}
		
		for(Integer el: res) {
			System.out.println(el);
		}
	}
}
