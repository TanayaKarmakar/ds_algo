package com.app.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// there are two arrays one is normal(A), another is permuted array(P)
// apply P to A
public class PermuteTheElementsOfAnArray {

	private static void applyPermutation(List<Integer> A, List<Integer> perm) {
		int n = A.size();

		for (int i = 0; i < n; i++) {
			while (perm.get(i) != i) {
				Collections.swap(A, i, perm.get(i));
				Collections.swap(perm, i, perm.get(i));
			}
		}
	}

	public static void main(String[] args) {
		int n = 4;
		List<Integer> A = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			A.add(i);
		}
		
		List<Integer> perm = new ArrayList<>();
		perm.add(2);
		perm.add(0);
		perm.add(1);
		perm.add(3);
		
		applyPermutation(A, perm);
		
		System.out.println(A);

	}

}
