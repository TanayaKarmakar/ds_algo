package com.app.dp1.problems;


//hackerrank
public class ReconstructTheArray {
	private static final int MOD = 1000000007;
	
	private static long numberOfWays(int n, int k, int x) {
		long oneCount = 1;
		long nonOneCount = 0;
		for(int i = 1; i < n; i++) {
			long prevOneCount = oneCount;
			oneCount = (nonOneCount * (k - 1))%MOD;
			nonOneCount = (prevOneCount + (nonOneCount * (k - 2)) % MOD)%MOD;
		}
		if(x == 1)
			return oneCount;
		else
			return nonOneCount;
	}

	public static void main(String[] args) {
		long numWays = numberOfWays(4, 3, 2);
		
		System.out.println("NumberOfWays - " + numWays);
	}

}
