package com.app.array.practice;

public class AlternateMinMax {
	private static void alternateMinMax(int[] arr) {
		int minIndx = 0;
		int maxIndx = arr.length - 1;
		int maxElem = arr[arr.length - 1] + 1;
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				arr[i] += (arr[maxIndx] % maxElem) * maxElem;
				maxIndx--;
			} else {
				arr[i] += (arr[minIndx] % maxElem) * maxElem;
				minIndx++;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print((arr[i] / maxElem) + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10,20,30,40,50,60,70,80,90,100,110};
		
		alternateMinMax(arr);

	}

}
