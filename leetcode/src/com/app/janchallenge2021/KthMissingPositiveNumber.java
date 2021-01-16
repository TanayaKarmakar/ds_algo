package com.app.janchallenge2021;

public class KthMissingPositiveNumber {
	private static final int MAX = 3010; 
	
	private static int findKthPositive(int[] arr, int k) {
		boolean[] present = new boolean[MAX];
		
		for(int i = 0; i < arr.length; i++) {
			int el = arr[i];
			present[el - 1] = true;
		}
		
		int c = 0;
		int i = 0;
		for(i = 0; i < MAX; i++) {
			if(!present[i])
				c++;
			if(c == k)
				break;
				
		}
		return i + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
