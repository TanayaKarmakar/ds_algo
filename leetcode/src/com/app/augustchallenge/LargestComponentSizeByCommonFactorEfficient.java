package com.app.augustchallenge;

import java.util.HashMap;
import java.util.Map;

class DisjointSet {
	int parent;
	int rank;

	public DisjointSet(int parent, int rank) {
		this.parent = parent;
		this.rank = rank;
	}
}

public class LargestComponentSizeByCommonFactorEfficient {
	
	private static int largestComponentSize(int[] A) {
		
	}

	public static void main(String[] args) {
		int[] nums = { 20, 50, 9, 63 };

		int ans = largestComponentSize(nums);

		System.out.println(ans);

	}

}
