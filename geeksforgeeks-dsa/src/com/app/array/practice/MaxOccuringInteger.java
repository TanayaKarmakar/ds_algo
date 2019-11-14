package com.app.array.practice;

public class MaxOccuringInteger {
	private static int maxOccuringInteger(int[] left, int[] right) {
		int max = (int) Math.pow(10, 6);
		int[] prefixArr = new int[max];
		int end = Integer.MIN_VALUE;

		int n = left.length;
		for (int i = 0; i < n; i++) {
			prefixArr[left[i]]++;
			prefixArr[right[i] + 1]--;
			if(right[i] + 1 > end) {
				end = right[i] + 1;
			}
		}
		
		int maxFreq = Integer.MIN_VALUE;
		int num = 0;
		
		for(int i = 0;i< end;i++) {
			prefixArr[i] += prefixArr[i - 1];
			if(prefixArr[i] > maxFreq) {
				maxFreq = prefixArr[i];
				num = i;
			}
			if(prefixArr[i] == maxFreq) {
				num = Integer.min(i, num);
			}
		}

		return num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
