package com.app.array;

import java.util.Arrays;

public class MoveAllZerosAtTheEnd {
	//quicksort like approach
	private static void reArrangeArray1(int[] arr) {
		int i = -1;
		int n = arr.length;
		int j = 0;
		while(j < n) {
			if(arr[j] > 0) {
				i++;
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
			j++;
		}
	}
	
	private static void reArrangeArray(int[] arr) {
		int n = arr.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] != 0) {
				arr[count] = arr[i];
				count++;
			}
		}

		while (count < n) {
			arr[count] = 0;
			count++;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 0, 4, 3, 0, 5, 0 };

		System.out.println("Before Array rearrangement");
		System.out.println(Arrays.toString(arr));

		reArrangeArray(arr);

		System.out.println("After Array rearrangement");
		System.out.println(Arrays.toString(arr));

		
		arr = new int[]{1,2,0,4,3,0,5,0};
		System.out.println("Before Array rearrangement1");
		System.out.println(Arrays.toString(arr));
		
		reArrangeArray1(arr);
		
		System.out.println("After Array rearrangement1");
		System.out.println(Arrays.toString(arr));
		
		arr = new int[]{0,1,0,4,3,2,0,7,0,8,0};
		System.out.println("Before Array rearragmenent1");
		System.out.println(Arrays.toString(arr));
		
		reArrangeArray1(arr);
		
		System.out.println("After Array rearrangement1");
		System.out.println(Arrays.toString(arr));
	}

}
