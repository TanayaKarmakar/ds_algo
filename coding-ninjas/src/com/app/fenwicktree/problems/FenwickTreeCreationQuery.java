package com.app.fenwicktree.problems;

public class FenwickTreeCreationQuery {
	private static int query(int indx, int[] bit) {
		int sum = 0;
		for(int i = indx; i > 0; i -= (i & (-i))) {
			sum += bit[i];
		}
		return sum;
	}
	
	private static int rangeQuery(int l, int r, int[] bit) {
		return query(r, bit) - query(l - 1, bit);
	}
	
	private static void update(int indx, int el, int[] bit, int n) {
		for(int i = indx; i < n; i += (i & (-i))) {
			bit[i] += el;
		}
	}

	public static void main(String[] args) {
		int[] arr = {Integer.MAX_VALUE, 1, 2, 4, 11, 8, 19, 20, 5};
		
		int n = arr.length;
		int[] bit = new int[n];
		
		for(int i = 1; i < n; i++) {
			update(i, arr[i], bit, n);
		}

		int l = 2;
		int r = 5;
		
		int rangeQuerySum = rangeQuery(l, r, bit);
		System.out.println("RangeQuerySum - " + rangeQuerySum);
	}

}
