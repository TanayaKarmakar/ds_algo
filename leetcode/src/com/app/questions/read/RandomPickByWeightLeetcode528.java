package com.app.questions.read;

import java.util.Random;

class Solution {
	int[] w;
	int[] preSum;
	int totalSum;
	public Solution(int[] w) {
		this.w = w;
		int sum = 0;
		this.preSum = new int[w.length];
		for(int i = 0; i < w.length; i++) {
			sum += w[i];
			preSum[i] = sum;
		}
		totalSum = sum;
	}
	
	public int pickIndex() {
		int finalNum = (int)(Math.random() * totalSum) + 1;
		int low = 0;
		int high = w.length - 1;
		while(low < high) {
			int mid = low + (high - low)/2;
			if(preSum[mid] < finalNum)
				low = mid + 1;
			else
				high = mid;
		}
		return low;
	}
}

public class RandomPickByWeightLeetcode528 {

	public static void main(String[] args) {
		

	}

}
