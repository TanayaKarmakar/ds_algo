package com.app.problems.gfg.dp.sample;

//problem statement - Given a number n, find count of 
//all binary sequences of length 2n such that sum of 
//first n bits is same as sum of last n bits.
public class CountEvenLengthBinarySeq {
	private static int countSetBits(int val) {
		int count = 0;
		while(val != 0) {
			count++;
			val = val & (val - 1);
		}
		return count;
	}
	
	private static int count(int n) {
		int len = 2*n;
		int size = (int)Math.pow(2, len);
		int[] dp = new int[size];
		
		dp[0] = 1;
		for(int i = 1; i < size; i++) {
			if(dp[i] != -1) {
				int count = countSetBits(i);
				if(count % 2 != 0) {
					int j = i;
					while(j < size) {
						dp[j] = -1;
						j = j << 2;
					}
				} else {
					
				}
			}	
		}
		return 0;
	}

	public static void main(String[] args) {
		

	}

}
